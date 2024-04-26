import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    static Queue<Edge> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n, m;
        while (!(input = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(input);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            queue = new PriorityQueue<>();
            parent = new int[n];
            Arrays.fill(parent, -1);

            int sum = 0;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                sum += w;
                queue.offer(new Edge(x, y, w));
            }

            int cnt = 0, res = 0;
            while (!queue.isEmpty()) {
                Edge cur = queue.poll();
                int from = cur.from;
                int to = cur.to;
                if (union(from, to)) {
                    res += cur.weight;
                    if (++cnt == n - 1) break;
                }
            }
            sb.append(sum - res).append('\n');
        }
        System.out.println(sb);
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false;
        parent[x] = y;
        return true;
    }

    private static int find(int x) {
        if (parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }

    private static class Edge implements Comparable<Edge> {
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
}
