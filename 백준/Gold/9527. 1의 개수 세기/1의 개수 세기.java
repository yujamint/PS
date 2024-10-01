import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long A, B;
    static long[] dp = new long[55];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        setDp();
        System.out.println(countOne(B) - countOne(A - 1));
    }

    private static long countOne(long N) {
        long ans = N & 1;
        int digit = (int) (Math.log(N) / Math.log(2)); // ln(N) / ln(2) = log2(N)
        for (int i = digit; i > 0; i--) {
            if ((N & (1L << i)) == 0) continue;
            long diff = N - (1L << i);
            ans += dp[i - 1] + diff + 1;
            N -= (1L << i);
        }
        return ans;
    }

    private static void setDp() {
        dp[0] = 1L;
        for (int i = 1; i < 55; i++) {
            dp[i] = (dp[i - 1] << 1) + (1L << i);
        }
    }
}
