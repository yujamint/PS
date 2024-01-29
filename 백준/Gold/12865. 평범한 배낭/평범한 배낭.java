import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] wArr, vArr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        wArr = new int[n + 1];
        vArr = new int[n + 1];
        int k = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][k + 1];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            wArr[i] = Integer.parseInt(st.nextToken());
            vArr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, wArr[i]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = min; j <= k; j++) {
                // i번째 물건을 넣으면 무게를 넘길 때
                if (wArr[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                }

                else {
                    dp[i][j] = Math.max(dp[i - 1][j - wArr[i]] + vArr[i], dp[i - 1][j]);
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
