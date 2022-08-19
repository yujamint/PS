package DP.타일채우기_2133;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dy = new int[n + 1];

        if (n >= 2) dy[2] = 3;

        for (int i = 3; i <= n; i++) {
            if (i % 2 == 1) continue;

            dy[i] = dy[i-2] * dy[2];
            for (int j = i-4; j >= 2; j=j-2) {
                dy[i] += dy[j] * 2;
            }
            dy[i] += 2;
        }

        System.out.println(dy[n]);
    }
}
