import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = 987654321;
    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;

    static int n, min = Integer.MAX_VALUE;
    static int[][] dp;
    static int[][] RGB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        RGB = new int[n + 1][3];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            RGB[i][RED] = Integer.parseInt(st.nextToken());
            RGB[i][GREEN] = Integer.parseInt(st.nextToken());
            RGB[i][BLUE] = Integer.parseInt(st.nextToken());
        }
        for (int k = 0; k < 3; k++) {
            dp = new int[n + 1][3];
            for (int i = 0; i < 3; i++) {
                if (i == k) dp[1][i] = RGB[1][i];
                else dp[1][i] = INF;
            }
            
            for (int i = 2; i <= n; i++) {
                dp[i][RED] = Math.min(dp[i - 1][BLUE], dp[i - 1][GREEN]) + RGB[i][RED];
                dp[i][GREEN] = Math.min(dp[i - 1][RED], dp[i - 1][BLUE]) + RGB[i][GREEN];
                dp[i][BLUE] = Math.min(dp[i - 1][RED], dp[i - 1][GREEN]) + RGB[i][BLUE];
            }    
            
            for (int i = 0; i < 3; i++) {
                if (i == k) continue;
                min = Math.min(min, dp[n][i]);
            }
        }
        

        System.out.println(min);
    }

}
