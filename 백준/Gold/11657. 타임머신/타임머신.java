import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = 6_000 * 10_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Edge(end, weight));
        }

        boolean minusCycle = false;
        long[] dist = new long[v + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                for (Edge edge : graph.get(j)) {
                    if (dist[j] != INF && dist[edge.end] > dist[j] + edge.weight) {
                        dist[edge.end] = dist[j] + edge.weight;
                        if (i == v) minusCycle = true;
                    }
                }
            }
        }

        if (minusCycle) {
            System.out.println(-1);
        }
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= v; i++) {
                long result = dist[i] == INF ? -1 : dist[i];
                sb.append(result).append("\n");
            }
            System.out.println(sb);
        }
    }

    private static class Edge {
        int end;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
