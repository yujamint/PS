import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp = new int[11];
//  dp[i] = i를 1,2,3의 합으로 나타내는 방법의 총 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            sb.append(dp[t]).append("\n");
        }
        System.out.println(sb);
    }
}
