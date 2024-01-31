import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dist = new int[n - 1];
        int[] price = new int[n - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int i = -1;
        int minPrice = Integer.MAX_VALUE;
        while (++i < n - 1) {
            if (minPrice > price[i]) {
                minPrice = price[i];
            }
            sum += minPrice * dist[i];
        }

        System.out.println(sum);
    }
}
