import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int LION = 1;
    static int min = Integer.MAX_VALUE;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lo = 0, hi = 0;
        int count = arr[lo] == LION ? 1 : 0;
        while (lo <= hi && hi < n) {
            if (count < k) {
                if (hi == n - 1) {
                    break;
                }
                if (arr[++hi] == LION) count++;
            } else {
                min = Math.min(min, hi - lo + 1);
                if (arr[lo] == LION) count--;
                lo++;
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
