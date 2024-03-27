import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
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

    static List<List<Edge>> graph;
    static int[] dist;
//    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        dist = new int[v + 1];
//        visited = new boolean[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, weight));
        }

        dist[start] = 0;
//        visited[start] = true;
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return dist[o1] - dist[o2];
            }
        });
        queue.offer(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            List<Edge> edges = graph.get(cur);
            for (Edge edge : edges) {
                if (dist[edge.to] > dist[cur] + edge.weight) {
                    dist[edge.to] = dist[cur] + edge.weight;
                    queue.offer(edge.to);
                }

//                dist[edge.to] = Math.min(dist[edge.to], dist[cur] + edge.weight);
//                if (visited[edge.to]) continue;
//                visited[edge.to] = true;
//                queue.offer(edge.to);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
        }
        System.out.println(sb);
    }

}
