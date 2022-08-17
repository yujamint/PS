package DP.가장큰증가부분수열_11055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = -1;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dy = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < n; i++) {
            dy[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dy[j] + arr[i] > dy[i]) dy[i] = dy[j] + arr[i];
            }
            max = Math.max(max, dy[i]);
        }

        System.out.println(max);
    }
}
