package DP.제곱수의합_1699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dy = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dy[i] = i;
            for (int j=1; j * j <= i; j++) {
                dy[i] = Math.min(dy[i], dy[i - (j * j)] + 1);
            }
        }

        System.out.println(dy[n]);

    }
}
