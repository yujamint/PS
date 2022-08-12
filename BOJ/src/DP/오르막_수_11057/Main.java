package DP.오르막_수_11057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mod = 10007;
        int n = Integer.parseInt(br.readLine());
        int[][] dy = new int[n + 1][10];

        for (int i = 0; i < 10; i++) {
            dy[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dy[i][j] += dy[i-1][k] % mod;
                }
            }
        }

        int result = 0;
        for (int x : dy[n]) {
            result += x;
        }

        System.out.println(result % mod);
    }
}
