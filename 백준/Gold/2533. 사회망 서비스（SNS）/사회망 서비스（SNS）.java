import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static final int ROOT = 1;

    static ArrayList<Integer>[] graph, tree;
    static int[] parent;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        tree = new ArrayList[n + 1];
        dp = new int[n + 1][2];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        makeTree(ROOT, -1);
        DFS(ROOT);
        System.out.println(Math.min(dp[ROOT][0], dp[ROOT][1]));
    }

    private static void DFS(int root) {
        dp[root][0] = 0;
        dp[root][1] = 1;

        for (int child : tree[root]) {
            DFS(child);
            dp[root][0] += dp[child][1];
            dp[root][1] += Math.min(dp[child][0], dp[child][1]);
        }
    }

    private static void makeTree(int root, int par) {
        ArrayList<Integer> connectedNodes = graph[root];
        for (int node : connectedNodes) {
            if (node == par) continue;
            tree[root].add(node);
            parent[node] = root;
            makeTree(node, root);
        }
    }

}
