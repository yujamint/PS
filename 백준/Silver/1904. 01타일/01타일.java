import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp = new int[1_000_001];
    // dp[i] = i개의 타일로 만들 수 있는 수열 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 15_746;
        }
        System.out.println(dp[n]);
    }
}
