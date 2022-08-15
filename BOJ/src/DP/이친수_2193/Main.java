package DP.이친수_2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] dy = new long[n + 1];
        dy[1] = 1;

        if (n == 1) {
            System.out.println(1);
        } else {
            for (int i = 2; i <= n; i++) {
                dy[i] = dy[i-1] +dy[i-2];
            }

            System.out.println(dy[n]);
        }
    }
}
