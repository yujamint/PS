package DP.암호코드_2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int dividor = 1_000_000;
        String str = br.readLine();
        int n = str.length();

        long[] dy = new long[n + 1];
        dy[0] = 1;

        if (n >= 1) dy[1] = 1;
        if (str.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        for (int i = 2; i <= n; i++) {
            int one = str.charAt(i-1) - '0';
            int two = str.charAt(i-2) - '0';
            if (one != 0) {
                dy[i] += dy[i-1];
                dy[i] %= dividor;

                if (two * 10 + one <= 26 && two * 10 + one > 10) {
                    dy[i] += dy[i-2];
                    dy[i] %= dividor;
                }
            }
            else { // one == 0일 때,
                if (two == 1 || two == 2) {
                    dy[i] += dy[i-2];
                    dy[i] %= dividor;
                }
                else {
                    System.out.println(0);
                    return;
                }
            }
        }

        System.out.println(dy[n] % dividor);
    }
}
