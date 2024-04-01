import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class Main {

    static class Edge {
        int end;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    private static final int INF = 50_000_000;

    static int v, visitedA, visitedB;
    static List<List<Edge>> graph;
    static List<Integer> candidates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            visitedA = Integer.parseInt(st.nextToken());
            visitedB = Integer.parseInt(st.nextToken());

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
                graph.get(to).add(new Edge(from, weight));
            }

            candidates = new ArrayList<>();
            for (int i = 0; i < c; i++) {
                candidates.add(Integer.parseInt(br.readLine()));
            }

            int[] fromStart = dijkstra(start);
            int[] fromVisitedA = dijkstra(visitedA);
            int[] fromVisitedB = dijkstra(visitedB);
            List<Integer> answers = filterCandidate(fromStart, fromVisitedA, fromVisitedB);

            Collections.sort(answers);
            for (int answer : answers) {
                sb.append(answer).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static List<Integer> filterCandidate(
            int[] fromStart,
            int[] fromVisitedA,
            int[] fromVisitedB
    ) {
        List<Integer> answers = new ArrayList<>();
        for (int candidate : candidates) {
            int min = fromStart[candidate];
            if (min >= INF) continue;

            int startToA = fromStart[visitedA];
            int AToB = fromVisitedA[visitedB];
            int BToCandidate = fromVisitedB[candidate];
            int resA = startToA + AToB + BToCandidate;

            int startToB = fromStart[visitedB];
            int BToA = fromVisitedB[visitedA];
            int AToCandidate = fromVisitedA[candidate];
            int resB = startToB + BToA + AToCandidate;

            int res = Math.min(resA, resB);
            if (res == min) {
                answers.add(candidate);
            }
        }
        return answers;
    }

    private static int[] dijkstra(int s) {
        int[] dist = new int[v + 1];
        boolean[] visited = new boolean[v + 1];
        Arrays.fill(dist, INF);
        dist[s] = 0;

        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return dist[o1] - dist[o2];
            }
        });
        queue.offer(s);
        while (!queue.isEmpty()) {
            int cur;
            do {
                cur = queue.poll();
            } while (!queue.isEmpty() && visited[cur]);
            if (visited[cur]) break;

            List<Edge> edges = graph.get(cur);
            for (Edge edge : edges) {
                if (dist[edge.end] > dist[cur] + edge.weight) {
                    dist[edge.end] = dist[cur] + edge.weight;
                    queue.offer(edge.end);
                }
            }
        }
        return dist;
    }

}
