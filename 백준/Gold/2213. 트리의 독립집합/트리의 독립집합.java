import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    private static final int ROOT = 1;
    static int[] weight;
    static int[][] dp;
    // dp[i][0] = i번 정점을 포함하지 않았을 때 최대 독립 집합의 크기
    // dp[i][1] = i번 정점을 포함했을 때 최대 독립 집합의 크기
    static ArrayList<Integer>[] graph, tree;
    static ArrayList<Integer>[][] history;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        weight = new int[n + 1];
        dp = new int[n + 1][2];
        graph = new ArrayList[n + 1];
        tree = new ArrayList[n + 1];
        history = new ArrayList[n + 1][2];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
            history[i][0] = new ArrayList<>();
            history[i][1] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        DFS(ROOT, -1);
        StringBuilder sb = new StringBuilder();
        if (dp[ROOT][0] > dp[ROOT][1]) {
            Collections.sort(history[ROOT][0]);
            sb.append(dp[ROOT][0]).append('\n');
            for (int h : history[ROOT][0]) {
                sb.append(h).append(' ');
            }
        }
        else {
            Collections.sort(history[ROOT][1]);
            sb.append(dp[ROOT][1]).append('\n');
            for (int h : history[ROOT][1]) {
                sb.append(h).append(' ');
            }
        }
        System.out.println(sb);
    }

    /*
        n번 노드에 자식이 m개 있다고 가정하자. (n+1, n+2, ... , n+m번 노드가 n번 노드의 자식이다.)
        i) n번 노드가 독립 집합에 포함된다면, n+1 ~ n+m번 노드는 독립 집합에 포함될 수 없다.
        ii) n번 노드가 독립 집합에 포함되지 않는다면, n+1 ~ n+m번 노드는 독립 집합에 포함될 수도, 포함되지 않을 수도 있다.
     */
    private static void DFS(int root, int parent) {
        dp[root][1] = weight[root];
        history[root][1].add(root);

        for (int connectedNode : graph[root]) {
            if (connectedNode == parent) continue;
            DFS(connectedNode, root);
            if (dp[connectedNode][0] > dp[connectedNode][1]) {
                dp[root][0] += dp[connectedNode][0];
                history[root][0].addAll(history[connectedNode][0]);
            }
            else {
                dp[root][0] += dp[connectedNode][1];
                history[root][0].addAll(history[connectedNode][1]);
            }
            dp[root][1] += dp[connectedNode][0];
            history[root][1].addAll(history[connectedNode][0]);
        }
    }

}
