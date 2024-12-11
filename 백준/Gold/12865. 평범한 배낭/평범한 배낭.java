import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp;
    static int[] weight, value;
    // dp(n개 물건, 사용 가능한 배낭 무게) = 가치 최대값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][maxWeight + 1];
        weight = new int[n + 1];
        value = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            int w = weight[i];
            for (int j = 0; j <= maxWeight; j++) {
                if (j >= w) dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + value[i]);
                else dp[i][j] = dp[i - 1][j];
            }
        }

        System.out.println(dp[n][maxWeight]);
    }
}
