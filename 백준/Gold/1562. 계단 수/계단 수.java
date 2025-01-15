import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int MOD = 1_000_000_000;

    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1][10][1024];

        for (int i = 1; i < 10; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int pos = 2; pos <= n; pos++) {
            for (int num = 0; num < 10; num++) {
                for (int visit = 0; visit < (1 << 10); visit++) {
                    int newVisit = visit | (1 << num);

                    if (num != 0) dp[pos][num][newVisit] += dp[pos - 1][num - 1][visit] % MOD;
                    if (num != 9) dp[pos][num][newVisit] += dp[pos - 1][num + 1][visit] % MOD;

                    dp[pos][num][newVisit] %= MOD;
                }
            }
        }

        long sum = 0L;
        for (int i = 0; i <= 9; i++) {
            sum += dp[n][i][(1 << 10) - 1] % MOD;
            sum %= MOD;
        }
        System.out.println(sum);
    }
}
