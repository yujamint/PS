import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = 987654321;

    static class Edge implements Comparable<Edge> {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static List<List<Edge>> graph = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(dist, INF);
        StringTokenizer st;
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, weight));
        }
        st = new StringTokenizer(br.readLine());
        int src = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());
        dist[src] = 0;
        dijkstra(src);
        System.out.println(dist[dest]);
    }

    private static void dijkstra(int start) {
        Queue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(start, 0));
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
    }

}
