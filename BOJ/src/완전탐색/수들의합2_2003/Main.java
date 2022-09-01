package 완전탐색.수들의합2_2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        int front = 0, rear = 0;

        while (front != n && rear != n) {
            int sum = 0;
            if (front > rear) rear = front;
            for (int i = front; i <= rear; i++) {
                sum += arr[i];
            }
            if (sum == m) {
                answer++;
                rear++;
            }
            else if (sum > m) {
                front++;
            }
            else {
                rear++;
            }
        }

        System.out.println(answer);
    }
}
