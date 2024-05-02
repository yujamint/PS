import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static final int ROOT = 1;
    static int[] citizenCount;
    static int[][] dp;
    // dp[i][0] = i번 노드가 우수마을이 아닐 때, i번 노드의 서브트리 우수 마을 주민 수 총합의 최대
    // dp[i][1] = i번 노드가 우수마을일 때, i번 노드의 서브트리 우수 마을 주민 수 총합의 최대
    static ArrayList<Integer>[] graph, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        citizenCount = new int[n + 1];
        dp = new int[n + 1][2];
        graph = new ArrayList[n + 1];
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            citizenCount[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        makeTree(ROOT, -1);
        DFS(ROOT);
        System.out.println(Math.max(dp[ROOT][0], dp[ROOT][1]));
    }

    private static void DFS(int root) {
        dp[root][0] = 0;
        dp[root][1] = citizenCount[root];

        for (int child : tree[root]) {
            DFS(child);
            dp[root][0] += Math.max(dp[child][0], dp[child][1]);
            dp[root][1] += dp[child][0];
        }
    }

    private static void makeTree(int root, int parent) {
        for (int connectedNode : graph[root]) {
            if (connectedNode == parent) continue;
            tree[root].add(connectedNode);
            makeTree(connectedNode, root);
        }
    }

}
