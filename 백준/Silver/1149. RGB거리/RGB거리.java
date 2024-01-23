import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp = new int[1_001][3], score;
    // dp[i][j] = i번째 집의 색을 j로 칠했을 때, 모든 집을 칠하는 비용의 최솟값
    /*
    0 - 빨간색, 1 - 초록색, 2 - 파란색
    dp[k][0] = dp[k - 1][1] + score[0], dp[k - 1][2] + score[0]
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        score = new int[n + 1][3];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            score[i][0] = Integer.parseInt(st.nextToken());
            score[i][1] = Integer.parseInt(st.nextToken());
            score[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[1][0] = score[1][0];
        dp[1][1] = score[1][1];
        dp[1][2] = score[1][2];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1] + score[i][0], dp[i - 1][2] + score[i][0]);
            dp[i][1] = Math.min(dp[i - 1][0] + score[i][1], dp[i - 1][2] + score[i][1]);
            dp[i][2] = Math.min(dp[i - 1][0] + score[i][2], dp[i - 1][1] + score[i][2]);
        }
        System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
    }
}
