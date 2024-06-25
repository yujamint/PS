import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pair implements Comparable<Pair> {
        int idx;
        int cost;

        public Pair(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair o) {
            return this.cost - o.cost;
        }
    }

    static int[] cost, indegree;
    static Queue<Pair> queue;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int T = 0; T < t; T++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            cost = new int[n + 1];
            indegree = new int[n + 1];
            queue = new PriorityQueue<>();
            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                indegree[b]++;
            }

            int w = Integer.parseInt(br.readLine());

            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) {
                    queue.offer(new Pair(i, cost[i]));
                }
            }

            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                Pair cur = queue.poll();
                int idx = cur.idx, c = cur.cost;

                max = Math.max(max, c);
                if (idx == w) {
                    break;
                }

                for (int outdegree : graph.get(idx)) {
                    if (--indegree[outdegree] == 0) {
                        queue.offer(new Pair(outdegree, cost[outdegree] + c));
                    }
                }
            }
            sb.append(max).append('\n');
        }
        System.out.println(sb);
    }

}
