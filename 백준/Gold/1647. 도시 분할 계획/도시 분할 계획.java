import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Edge implements Comparable<Edge> {
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

    static int n, m, sum = 0;
    static int[] parent;
    static Queue<Edge> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        Arrays.fill(parent, -1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            queue.offer(new Edge(from - 1, to - 1, weight));
        }

        kruskal();
        System.out.println(sum);
    }

    private static void kruskal() {
        int connect = 1;
        while (!queue.isEmpty() && connect < n - 1) {
            Edge cur = queue.poll();
            int from = cur.from, to = cur.to;
            if (find(from) != find(to)) {
                union(from, to);
                connect++;
                sum += cur.weight;
            }
        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        parent[x] = y;
    }

    private static int find(int x) {
        if (parent[x] < 0) return x;
        else return parent[x] = find(parent[x]);
    }

}
