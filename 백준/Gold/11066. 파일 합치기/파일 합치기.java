import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] arr;
        int[] sum;
        StringBuilder sb = new StringBuilder();
        for (int test = 0; test < t; test++) {
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[k + 2];
            sum = new int[k + 1];
            for (int i = 1; i <= k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + arr[i];
            }
            dp = new int[k + 2][k + 2];

            for (int end = 2; end <= k; end++) {
                for (int start = end - 1; start >= 1; start--) {
                    int min = Integer.MAX_VALUE;
                    for (int mid = start; mid < end; mid++) {
                        min = Math.min(min, dp[start][mid] + dp[mid + 1][end]);
                    }
                    dp[start][end] = min + sum[end] - sum[start - 1];
                }
            }
            sb.append(dp[1][k]).append("\n");
        }
        System.out.println(sb);
    }
}
