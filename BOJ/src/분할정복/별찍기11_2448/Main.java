package 분할정복.별찍기11_2448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static String[] arr;

    public static void star(int N) {
        int start = N / 2;

        for (int i = start; i < N; i++) {
            arr[i] = arr[i - start] + " " + arr[i - start];
        }

        for (int i = 0; i < start; i++) {
            arr[i] = " ".repeat(start) + arr[i] + " ".repeat(start);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        arr = new String[n];

        arr[0] = "  *  ";
        arr[1] = " * * ";
        arr[2] = "*****";

        for (int i = 6; i <= n; i *= 2) {
            star(i);
        }

        for (String row : arr) {
            System.out.println(row);
        }
    }
}
