package DP.더하기123_9095;

import java.util.Scanner;

public class Main {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int max = Integer.MIN_VALUE;

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }
        int[] dy = new int[max + 1];
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;

        for (int i = 4; i <= max; i++) {
            dy[i] = dy[i - 1] + dy[i - 2] + dy[i - 3];
        }

        for (int i = 0; i < n; i++) {
            System.out.println(dy[arr[i]]);
        }
    }
}
