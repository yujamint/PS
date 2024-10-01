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
        if (N == 0 || N == 1) {
            return N;
        }

        int digit = 0;
        long num = 1;
        while (num * 2 <= N) {
            num *= 2;
            digit++;
        }

        long diff = N - num + 1;
        return dp[digit - 1] + diff + countOne(N - num);
    }
    
    private static void setDp() {
        dp[0] = 1L;
        for (int i = 1; i < 55; i++) {
            dp[i] = (dp[i - 1] << 1) + (1L << i);
        }
    }
}
