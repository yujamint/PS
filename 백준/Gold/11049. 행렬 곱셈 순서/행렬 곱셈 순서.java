import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    // dp[i][j] = i번째 행렬부터 j번째 행렬까지 곱했을 때 필요한 연산의 최소 횟수
    /*
    A 행렬: N x M
    B 행렬: M x K
    dp[k][k + 1] = N * M * K
    dp[start][end] = dp[start][mid] + dp[mid + 1][end] + arr[start][0] * arr[mid][1] * arr[end][1]
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][3];
        dp = new int[n + 1][n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            dp[i][i + 1] = arr[i][1] * arr[i][2] * arr[i + 1][2];
        }

        for (int end = 2; end <= n; end++) {
            for (int start = end - 1; start >= 1; start--) {
                dp[start][end] = Integer.MAX_VALUE;
                for (int mid = start; mid < end; mid++) {
                    dp[start][end] = Math.min(dp[start][end], dp[start][mid] + dp[mid + 1][end] + arr[start][1] * arr[mid][2] * arr[end][2]);
                }
            }
        }

        System.out.println(dp[1][n]);
    }
}
