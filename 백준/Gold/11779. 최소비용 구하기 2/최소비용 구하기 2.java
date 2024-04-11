import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    private static final int INF = 987654321;

    static int n;
    static List<List<Edge>> graph = new ArrayList<>();
    static int[] dist, history;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(from, to, weight));
        }
        st = new StringTokenizer(br.readLine());
        int source = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());
        dijkstra(source, destination);
        StringBuilder sb = new StringBuilder();
        sb.append(dist[destination]).append('\n');

        Stack<Integer> stack = new Stack<>();
        int temp = destination;
        while (temp != -1) {
            stack.push(temp);
            temp = history[temp];
        }
        sb.append(stack.size()).append('\n');

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }
        System.out.println(sb);
    }

    private static void dijkstra(int source, int destination) {
        dist = new int[n + 1];
        history = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(dist, INF);
        dist[source] = 0;

        Queue<Edge> queue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        queue.offer(new Edge(-1, source, 0));

        while (!queue.isEmpty()) {
            Edge cur;
            do {
                cur = queue.poll();
            } while (!queue.isEmpty() && visited[cur.end]);
            if (visited[cur.end]) break;
            visited[cur.end] = true;
            history[cur.end] = cur.start;

            for (Edge edge : graph.get(cur.end)) {
                if (dist[edge.end] > dist[cur.end] + edge.weight) {
                    dist[edge.end] = dist[cur.end] + edge.weight;
                    queue.offer(new Edge(cur.end, edge.end, dist[edge.end]));
                }
            }
        }
    }

}
