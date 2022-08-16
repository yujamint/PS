package DP.가장긴증가하는부분수열_11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 1;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dy = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dy[i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (arr[i] > arr[j]) dy[i] = Math.max(dy[i], dy[j] + 1);
            }
            max = Math.max(max, dy[i]);
        }

        System.out.println(max);
    }
}
