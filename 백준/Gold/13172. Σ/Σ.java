import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int MOD = 1_000_000_007;

    static long N, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;

        N = 1;
        S = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            S = s * N + S * n;
            N *= n;

            S %= MOD;
            N %= MOD;
        }
        long gcd = calculateGCD(Math.max(S, N), Math.min(S, N));
        S /= gcd;
        N /= gcd;
        long res = mod(MOD - 2);
        long answer = ((res % MOD) * (S % MOD)) % MOD;
        System.out.println(answer);
    }

    private static long calculateGCD(long a, long b) {
        long temp = a % b;
        while (temp != 0) {
            a = b;
            b = temp;
            temp = a % b;
        }
        return b;
    }

    private static long mod(int exp) {
        if (exp == 1) {
            return N;
        }
        long temp = mod(exp / 2);
        long res = ((temp % MOD) * (temp % MOD)) % MOD;
        if (exp % 2 == 0) return res;
        else return ((res % MOD) * (N % MOD)) % MOD;
    }

}
