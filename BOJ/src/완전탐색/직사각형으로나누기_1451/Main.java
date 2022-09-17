package 완전탐색.직사각형으로나누기_1451;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[][] arr;

    public static int sum(int ax, int ay, int bx, int by) {
        int sum = 0;
        for (int i = ax; i <= bx; i++) {
            for (int j = ay; j <= by; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        arr = new int[n+1][m+1];
        int total = 0;
        long max = Long.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                int num = str.charAt(j-1) - '0';
                arr[i][j] = num;
                total += num;
            }
        }

        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                long s1 = sum(1, 1, i, m);
                long s2 = sum(i+1, 1, j, m);
                long s3 = total - (s1 + s2);

                max = Math.max(max, s1 * s2 * s3);
            }
        }

        for (int i = 1; i <= m - 2; i++) {
            for (int j = i + 1; j <= m - 1; j++) {
                long s1 = sum(1, 1, n, i);
                long s2 = sum(1, i+1, n, j);
                long s3 = total - (s1 + s2);

                max = Math.max(max, s1 * s2 * s3);
            }
        }

        for (int i = 1; i <= n-1; i++) {
            for (int j = 1; j <= m - 1; j++) {
                long s1 = sum(i + 1, 1, n, m);
                long s2 = sum(1, 1, i, j);
                long s3 = total - (s1 + s2);
                max = Math.max(max, s1 * s2 * s3);

                s1 = sum(1, 1, i, m);
                s2 = sum(i + 1, 1, n, j);
                s3 = total - (s1 + s2);
                max = Math.max(max, s1 * s2 * s3);

                s1 = sum(1,1, n, j);
                s2 = sum(1, j + 1, i, m);
                s3 = total - (s1 + s2);
                max = Math.max(max, s1 * s2 * s3);

                s1 = sum(1, 1, i, j);
                s2 = sum(i + 1, 1, n, j);
                s3 = total - (s1 + s2);
                max = Math.max(max, s1 * s2 * s3);
            }
        }
        System.out.println(max);
    }
}