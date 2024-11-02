import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
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

public class Main {

    private static final int INF = 1234567890;

    static int n;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[] visited;
    static List<List<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            visited = new boolean[n * n];
            graph = new ArrayList<>();
            for (int i = 0; i < n * n; i++) {
                graph.add(new ArrayList<>());
            }
            int startWeight = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int v = i * n + j;
                    int w = Integer.parseInt(st.nextToken());
                    if (i == 0 && j == 0) startWeight = w;
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= n || x < 0 || y >= n || y < 0) continue;
                        int nv = x * n + y;
                        graph.get(nv).add(new Edge(v, w));
                    }
                }
            }
            int[] dist = dijkstra();
            sb.append("Problem ").append(t++).append(": ").append(dist[n * n - 1] + startWeight).append('\n');
        }
        System.out.println(sb);
    }

    private static int[] dijkstra() {
        int[] dist = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            if (i != 0) dist[i] = INF;
        }
        Queue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(0, 0));
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

