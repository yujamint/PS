import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int INF = 1234567890;

    static int n, d, c;
    static List<List<Edge>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int T = 0; T < t; T++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            visited = new boolean[n + 1];
            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                graph.get(b).add(new Edge(a, w));
            }

            long[] dist = dijkstra(c);

            int count = 0;
            long max = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                if (dist[i] != INF) {
                    count++;
                    max = Math.max(max, dist[i]);
                }
            }
            sb.append(count).append(' ').append(max).append('\n');
        }
        System.out.println(sb);
    }

    private static long[] dijkstra(int c) {
        long[] dist = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i != c) dist[i] = INF;
        }
        Queue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(c, 0));
        while (!queue.isEmpty()) {
            int cur;
            do {
                cur = queue.poll().to;
            } while (!queue.isEmpty() && visited[cur]);
            if (visited[cur]) break;

            visited[cur] = true;

            for (Edge edge : graph.get(cur)) {
                if (dist[edge.to] > dist[cur] + edge.weight) {
                    dist[edge.to] = dist[cur] + edge.weight;
                    queue.offer(new Edge(edge.to, dist[edge.to]));
                }
            }
        }
        return dist;
    }

}

class Edge implements Comparable<Edge> {
    int to;
    long weight;

    public Edge(int to, long weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.weight == o.weight) {
            return 0;
        } else if (this.weight > o.weight) {
            return 1;
        }
        return -1;
    }
}
