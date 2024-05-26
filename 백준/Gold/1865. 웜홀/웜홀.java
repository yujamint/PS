import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Edge {

        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private static final int INF = 25_000_000;
    static int n, m, w;
    static int[] dist;
    static List<List<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int T = 0; T < t; T++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                graph.get(a).add(new Edge(b, weight));
                graph.get(b).add(new Edge(a, weight));
            }

            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int weight = -Integer.parseInt(st.nextToken());
                graph.get(a).add(new Edge(b, weight));
            }

            boolean minusCycle = bellmanFord();
            sb.append(minusCycle ? "YES" : "NO").append('\n');
        }
        System.out.println(sb);

    }

    private static boolean bellmanFord() {
        dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i != 1) {
                dist[i] = INF;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (Edge edge : graph.get(j)) {
                    int next = edge.to, weight = edge.weight;
                    if (dist[next] > dist[j] + weight) {
                        dist[next] = dist[j] + weight;
                        if (i == n) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}
