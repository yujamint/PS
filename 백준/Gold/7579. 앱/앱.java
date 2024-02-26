import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] memory = new int[N];
        int[] cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }
        int costSum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            costSum += cost[i];
        }
        int[] dp = new int[costSum + 1];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = costSum; j >= cost[i]; j--) {
                int temp = dp[j - cost[i]] + memory[i];
                dp[j] = Math.max(dp[j], temp);
                if (dp[j] >= M) {
                    min = Math.min(min, j);
                }
            }
        }

        System.out.println(min);
    }
}
