import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dp = new int[101][10];
    // dp[i][j] = 길이가 i이면서 1의 자리가 j인 계단 수

    /*
    dp[i] = dp[i-1] * 2 - (i - 1)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][j + 1];
                else if (j == 9) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000;
            }
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[n][i]) % 1_000_000_000;
        }
        System.out.println(sum);
    }
}
