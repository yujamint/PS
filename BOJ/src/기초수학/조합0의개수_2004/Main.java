package 기초수학.조합0의개수_2004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long twoCnt = 0L;
        long fiveCnt = 0L;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        twoCnt = divide(n, 2) - divide(m, 2) - divide(n - m, 2);
        fiveCnt = divide(n, 5) - divide(m, 5) - divide(n - m, 5);

        System.out.println(Math.min(twoCnt, fiveCnt));
    }

    public static int divide(int n, int k) {
        int cnt = 0;
        while (n >= k) {
            cnt += n / k;
            n /= k;
        }
        return cnt;
    }
}
