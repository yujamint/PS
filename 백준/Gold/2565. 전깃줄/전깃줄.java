import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp = new int[501];
    // dp[i] = i번 전깃줄까지 연결했을 때 연결 가능한 전깃줄의 최대 수
    static int[] arr = new int[501];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int end = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from] = to;
            end = Math.max(end, from);
        }

        for (int i = 1; i <= end; i++) {
            if (arr[i] == 0) continue;
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int max = -1;
        for (int i = 1; i <= end; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(n - max);
    }
}
