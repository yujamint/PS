package DP.가장긴바이토닉부분수열_11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] front = new int[n];
        int[] rear = new int[n];
        int[] dy = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            front[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && front[j] + 1 > front[i]) front[i] = front[j] + 1;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            rear[i] = 1;
            for (int j = i; j < n; j++) {
                if (arr[i] > arr[j] && rear[j] + 1 > rear[i]) rear[i] = rear[j] + 1;
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            dy[i] = front[i] + rear[i] - 1;
            max = Math.max(max, dy[i]);
        }

        System.out.println(max);
    }
}
