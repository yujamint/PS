package DP.타일링2xN_2_11727;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 1) {
            System.out.println(1);
            return;
        }

        int[] dy = new int[n + 1];
        dy[1] = 1; dy[2] = 3;

        for (int i = 3; i <= n; i++) {
            dy[i] = (dy[i - 1] + 2 * dy[i - 2]) % 10007;
        }

        System.out.println(dy[n] % 10007);
    }
}
