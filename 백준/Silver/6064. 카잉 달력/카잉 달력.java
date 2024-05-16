import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int m, n, x, y;
        long cnt;
        for (int T = 0; T < t; T++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            cnt = -1;
            int gcd = euclid(Math.max(m, n), Math.min(m, n));
            long lcm = (long) m * n / gcd;
            for (long i = x; i < lcm; i+=m) {
                int a = (int) i % m;
                int b = (int) i % n;
                if (a == x && b == y) {
                    cnt = i + 1;
                    break;
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }

    private static int euclid(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }

}
