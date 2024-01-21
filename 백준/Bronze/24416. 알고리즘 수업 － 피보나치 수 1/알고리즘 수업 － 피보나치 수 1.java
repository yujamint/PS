import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int recursionCount = 0, dpCount = 0;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fibo(n);
        dp = new int[n + 1];
        fibonacci(n);
        System.out.println(recursionCount + " " + dpCount);
    }

    private static int fibo(int n) {
        if (n == 1 || n == 2) {
            recursionCount++;
            return 1;
        }
        else return (fibo(n - 1) + fibo(n - 2));
    }

    private static int fibonacci(int n) {
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dpCount++;
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
