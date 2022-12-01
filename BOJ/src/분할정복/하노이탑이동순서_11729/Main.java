package 분할정복.하노이탑이동순서_11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static StringBuilder sb;

    public static void hanoi(int N, int start, int mid, int to) {
        if (N == 1) {
            sb.append(start).append(' ').append(to).append('\n');
            return;
        }

        hanoi(N - 1, start, to, mid);

        sb.append(start).append(' ').append(to).append('\n');

        hanoi(N - 1, mid, start, to);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        sb.append((int) Math.pow(2, n) - 1).append('\n');
        hanoi(n, 1, 2, 3);

        System.out.println(sb);
    }
}
