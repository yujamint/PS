import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        double weight;

        public Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    static Node[] arr;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new Node[n + 1];
        parent = new int[n + 1];
        Arrays.fill(parent, -1);

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Node(x, y);
        }

        Queue<Edge> queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            Node cur = arr[i];
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                Node other = arr[j];
                double dist = calculateDistance(cur, other);
                queue.offer(new Edge(i, j, dist));
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (union(x, y)) cnt++;
        }

        double res = 0;
        while (!queue.isEmpty()) {
            Edge cur = queue.poll();
            int x = cur.from;
            int y = cur.to;

            if (union(x, y)) {
                res += cur.weight;
                if (++cnt == n - 1) break;
            }
        }

        System.out.printf("%.2f", res);
    }

    private static double calculateDistance(Node cur, Node other) {
        int xDiff = cur.x - other.x;
        int yDiff = cur.y - other.y;
        return Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
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

}
