package DP.파도반수열_9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] testCase = new int[T];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < T; i++) {
            testCase[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, testCase[i]);
        }

        long[] dy = new long[max + 1];

        if (max <=3) {
            for (int i = 1; i <= max; i++) {
                dy[i] = 1;
            }
        }
        else if (max == 4) {
            for (int i = 1; i < max; i++) {
                dy[i] = 1;
            }
            dy[max] = 2;
        }
        else {
            dy[1] = 1; dy[2] = 1; dy[3] = 1; dy[4] = 2;
            for (int i = 5; i <= max; i++) {
                dy[i] = dy[i - 5] + dy[i - 1];
            }
        }

        for (int x : testCase)
            System.out.println(dy[x]);
    }
}
