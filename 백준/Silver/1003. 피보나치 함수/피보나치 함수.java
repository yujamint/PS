import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[][] dp = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        dp[0][0] = 1;
        dp[1][1] = 1;
        for (int T = 0; T < t; T++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(fibo0(n)).append(' ').append(fibo1(n)).append('\n');
        }
        System.out.println(sb);
    }

    private static int fibo0(int n) {
        if (n == 1) return 0;
        if (dp[n][0] != 0) return dp[n][0];
        else return dp[n][0] += fibo0(n - 1) + fibo0(n - 2);
    }

    private static int fibo1(int n) {
        if (n == 0) return 0;
        if (dp[n][1] != 0) return dp[n][1];
        else return dp[n][1] += fibo1(n - 1) + fibo1(n - 2);
    }

}
