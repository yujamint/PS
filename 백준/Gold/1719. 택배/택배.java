import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

public class Main {
    private static final int INF = 1234567890;

    static int n, m;
    static List<List<Edge>> graph = new ArrayList<>();
    static int[][] path;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        path = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) path[i][j] = -1;
            }
        }
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(a, b, w));
            graph.get(b).add(new Edge(b, a, w));
        }

        dijkstra();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (path[i][j] == 0) sb.append('-');
                else sb.append(path[i][j]);
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void dijkstra() {
        Queue<Edge> queue;
        int[] dist;
        for (int v = 1; v <= n; v++) {
            dist = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                if (i != v) dist[i] = INF;
            }

            visited = new boolean[n + 1];
            queue = new PriorityQueue<>();
            queue.offer(new Edge(0, v, 0));
            while (!queue.isEmpty()) {
                int cur;
                int from;
                do {
                    Edge poll = queue.poll();
                    cur = poll.to;
                    from = poll.from;
                } while (!queue.isEmpty() && visited[cur]);
                if (visited[cur]) break;
                visited[cur] = true;

                if (v == from) {
                    path[v][cur] = cur;
                } else {
                    int tmp = from;
                    while (path[v][tmp] > 0 && path[v][tmp] != tmp) {
                        tmp = path[v][tmp];
                    }
                    path[v][cur] = tmp;
                }

                for (Edge edge : graph.get(cur)) {
                    if (dist[edge.to] > dist[cur] + edge.weight) {
                        dist[edge.to] = dist[cur] + edge.weight;
                        queue.offer(new Edge(cur, edge.to, dist[edge.to]));
                    }
                }
            }
        }
    }
}
