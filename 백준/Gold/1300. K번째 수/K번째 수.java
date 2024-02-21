import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        int lo = 1, hi = k;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (count(mid) < k) lo = mid + 1;
            else hi = mid;
        }
        System.out.println(lo);
    }

    private static int count(int mid) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int temp = Math.min(mid / i, n);
            if (temp == 0) return count;
            else count += temp;
        }
        return count;
    }
}
