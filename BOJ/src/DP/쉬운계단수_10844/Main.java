package DP.쉬운계단수_10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long mod = 1_000_000_000L;

        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n + 1][10];
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if(j==0) dp[i][j] = dp[i - 1][j+1] % mod;
                else if (j==9) dp[i][j] = dp[i - 1][j-1] % mod;
                else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
            }
        }

        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[n][i];
        }

        System.out.println(answer%mod);
    }
}
