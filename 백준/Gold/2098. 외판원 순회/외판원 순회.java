import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, INF = 987654321;
    static int[][] dist;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dist = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(tsp(0, 1));
    }

    private static int tsp(int cur, int visited) {
        if (visited == (1 << n) - 1) {
            if (dist[cur][0] == 0) return INF;
            else return dist[cur][0];
        }

        if (dp[cur][visited] != -1) return dp[cur][visited];

        dp[cur][visited] = INF;
        for (int i = 0; i < n; i++) {
            int next = visited | (1 << i);

            if ((visited & (1 << i)) != 0 || dist[cur][i] == 0) continue;

            dp[cur][visited] = Math.min(dp[cur][visited], tsp(i, next) + dist[cur][i]);
        }

        return dp[cur][visited];
    }
}
