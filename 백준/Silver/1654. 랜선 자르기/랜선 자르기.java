import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] LAN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        LAN = new int[k];

        long max = 0;
        for (int i = 0; i < k; i++) {
            LAN[i] = Integer.parseInt(br.readLine());
            if (max < LAN[i]) {
                max = LAN[i];
            }
        }

        max++;
        long min = 0;
        long mid = 0;
        while (min < max) {
            mid = (min + max) / 2;
            long cnt = 0;
            for (int i = 0; i < k; i++) {
                cnt += (LAN[i] / mid);
            }

            if (cnt >= n) {
                min = mid + 1;
            }
            else {
                max = mid;
            }
        }
        System.out.println(min - 1);
    }
}
