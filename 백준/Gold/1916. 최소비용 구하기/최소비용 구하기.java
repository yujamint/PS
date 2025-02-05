import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int to;
    long cost;

    public Edge(int to, long cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return (int) (this.cost - o.cost);
    }
}

public class Main {

    static final long INF = 100_000L * 100_000 + 1;
    static int n, m;
    static List<List<Edge>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int source = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());

        long[] dist = dijkstra(source);
        System.out.println(dist[dest]);
    }

    private static long[] dijkstra(int from) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(from, 0));

        long[] dist = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i != from) dist[i] = INF;
        }

        while (!queue.isEmpty()) {
            Edge cur;
            do {
                cur = queue.poll();
            } while (!queue.isEmpty() && visited[cur.to]);
            if (visited[cur.to]) break;

            visited[cur.to] = true;

            for (Edge edge : graph.get(cur.to)) {
                if (dist[edge.to] > dist[cur.to] + edge.cost) {
                    dist[edge.to] = dist[cur.to] + edge.cost;
                    queue.offer(new Edge(edge.to, dist[edge.to]));
                }
            }
        }

        return dist;
    }
}
