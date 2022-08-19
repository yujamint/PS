package DP.계단오르기_2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dy = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dy[1] = arr[1];

        if (n > 1) dy[2] = arr[1] + arr[2];

        for (int i = 3; i <= n; i++) {
            dy[i] = Math.max(dy[i-2] + arr[i], dy[i-3] + arr[i-1] + arr[i]);
        }

        System.out.println(dy[n]);
    }
}
