import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Pair {
        int len;
        int prevIdx;

        public Pair(int len, int prevIdx) {
            this.len = len;
            this.prevIdx = prevIdx;
        }
    }

    static Pair[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        dp = new Pair[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            dp[i] = new Pair(1, -1);
        }
        Pair max = new Pair(1, -1);
        int maxIdx = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j] && dp[i].len <= dp[j].len) {
                    dp[i] = new Pair(dp[j].len + 1, j);
                    if (dp[i].len > max.len) {
                        max = dp[i];
                        maxIdx = i;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max.len).append('\n');
        List<Integer> answer = new ArrayList<>();
        answer.add(arr[maxIdx]);
        while (max.prevIdx != -1) {
            answer.add(arr[max.prevIdx]);
            max = dp[max.prevIdx];
        }
        for (int i = answer.size() - 1; i >= 0; i--) {
            sb.append(answer.get(i)).append(' ');
        }
        System.out.println(sb);
    }

}
