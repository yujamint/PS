import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] candy;
    static int[] parent;
    static int[] count;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        candy = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[n + 1];
        count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = -1;
            count[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        List<Integer> groupIdx = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (count[i] <= 30000) {
                groupIdx.add(i);
            }
        }

        int len = groupIdx.size();
        dp = new int[len + 1][k];
        for (int i = 1; i <= len; i++) {
            int idx = groupIdx.get(i - 1);
            int weight = count[idx];
            int value = candy[idx];
            for (int j = 1; j < k; j++) {
                if (weight > j) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
            }
        }

        System.out.println(dp[len][k - 1]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[x] = y;
            count[y] += count[x];
            candy[y] += candy[x];
            count[x] = Integer.MAX_VALUE;
        }
    }

    private static int find(int x) {
        if (parent[x] < 0) return x;
        else return parent[x] = find(parent[x]);
    }
}
