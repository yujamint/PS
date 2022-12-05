package 그리디.동전0_11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int index = n - 1;
        int cnt = 0;
        while (k > 0) {
            int coin = coins[index];

            if (k < coin) {
                index--;
            }
            else {
                k -= coin;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
