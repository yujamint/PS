import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] isGood;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        isGood = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int idx = 0; idx < n; idx++) {
            int lo = 0, hi = n - 1;
            int target = arr[idx];
            while (lo < hi) {
                if (lo == idx) {
                    lo++;
                    continue;
                }
                if (hi == idx) {
                    hi--;
                    continue;
                }
                int val = arr[lo] + arr[hi];
                if (val == target) {
                    isGood[idx] = true;
                    break;
                } else if (val < target) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (isGood[i]) cnt++;
        }
        System.out.println(cnt);
    }
}
