import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long cnt = 0;
        int[] sum = new int[n + 1];
        int[] remainder = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum[i] = (sum[i - 1] + num) % m;
            if (sum[i] == 0) cnt++;
            remainder[sum[i]]++;
        }

        for (int i = 0; i < m; i++) {
            cnt += (long) remainder[i] * (remainder[i] - 1) / 2;
        }

        System.out.println(cnt);
    }
}
