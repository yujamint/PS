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

        int end;
        int weight;

        public Edge(int end, int weight) {
            this.weight = weight;
            this.end = end;
        }
    }

    private static final int INF = 200_000_000;

    static int n;
    static List<List<Edge>> graph = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int e = Integer.parseInt(st.nextToken());
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Edge(end, weight));
            graph.get(end).add(new Edge(start, weight));
        }
        st = new StringTokenizer(br.readLine());
        int must1 = Integer.parseInt(st.nextToken());
        int must2 = Integer.parseInt(st.nextToken());

        int[] from1To = dijkstra(1);
        int[] fromMust1To = dijkstra(must1);
        int[] fromMust2To = dijkstra(must2);

        int answer = from1To[must1] + fromMust1To[must2] + fromMust2To[n];
        answer = Math.min(answer, from1To[must2] + fromMust2To[must1] + fromMust1To[n]);

        if (answer >= INF) System.out.println(-1);
        else System.out.println(answer);

        /*
        1, must1, must2에서 dijkstra 돌린다
        (1) 1 -> must1 -> must2 -> n
        (2) 1 -> must2 -> must1 -> n
         */
    }

    private static int[] dijkstra(int start) {
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        Queue<Integer> queue = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return dist[o1] - dist[o2];
                    }
                }
        );
        queue.offer(start);
        while (!queue.isEmpty()) {
            int cur;
            do {
                cur = queue.poll();
            } while (!queue.isEmpty() && visited[cur]);
            if (visited[cur]) break;

            for (Edge edge : graph.get(cur)) {
                if (dist[edge.end] > dist[cur] + edge.weight) {
                    dist[edge.end] = dist[cur] + edge.weight;
                    queue.offer(edge.end);
                }
            }
        }
        return dist;
    }

}
