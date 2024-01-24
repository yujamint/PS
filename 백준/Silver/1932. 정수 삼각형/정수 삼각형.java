import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp = new int[502][502];
    // dp[i][j] = i층에서 j번쨰 인덱스의 수로 내려왔을 때 경로의 최대합

    /*
    dp[i][j] = Math.max(dp[i-1][j] + arr[i][j], dp[i-1][j+1] + arr[i][j])
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = arr[1][1];
        int max = dp[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j] + arr[i][j], dp[i - 1][j - 1] + arr[i][j]);
                if (i == n) max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
    }
}
