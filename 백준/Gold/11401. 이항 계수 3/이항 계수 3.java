import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int mod = 1_000_000_007;
    static long[] fac, inv;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        fac = new long[n + 1];
        inv = new long[n + 1];

        fac[1] = 1;
        for (int i = 2; i <= n; i++) {
            fac[i] = fac[i - 1] * i % mod;
        }

        inv[0] = 1;
        inv[n] = pow(fac[n], mod - 2);
        for (int i = n - 1; i >= 1; i--) {
            inv[i] = inv[i + 1] * (i + 1) % mod;
        }

        long answer = (fac[n] * inv[k] % mod * inv[n - k] % mod) % mod;
        System.out.println(answer);
    }

    private static long pow(long n, int exponent) {
        long res = 1;
        for (; exponent > 0; exponent >>= 1, n = n * n % mod) {
            if (exponent % 2 == 1) res = res * n % mod;
        }
        return res;
    }
}
