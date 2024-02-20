import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int[] home = new int[n];
        for (int i = 0; i < n; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);

        int lo = 1, hi = (home[home.length - 1] - home[0]) / (c - 1) + 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int cnt = count(home, mid);
            // upper bound를 구해야 한다.
            // cnt == c가 되게 하는 가장 큰 값을 구해야 하기 때문.
            if (cnt >= c) lo = mid + 1;
            else hi = mid;
        }

        System.out.println(lo - 1);
    }

    private static int count(int[] home, int mid) {
        // 시작 지점에 공유기 설치하고 시작
        int cnt = 1, prev = home[0];

        for (int i = 1; i < home.length; i++) {
            int cur = home[i];
            if (prev + mid <= cur) {
                cnt++;
                prev = cur;
            }
            if (cnt >= c) return cnt;
        }

        return cnt;
    }
}
