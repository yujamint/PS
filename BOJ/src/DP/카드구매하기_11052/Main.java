package DP.카드구매하기_11052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dy = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dy[1] = arr[1];

        for (int i = 2; i <= n; i++) {
            dy[i] = arr[i];
            for (int j = i/2; j >= 1; j--) {
                dy[i] = Math.max(dy[i], dy[i - j] + arr[j]);
            }
        }

        System.out.println(dy[n]);
    }
}
