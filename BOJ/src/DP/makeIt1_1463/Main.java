package DP.makeIt1_1463;

import java.util.Scanner;

public class Main {
    static int[] dy;

    public int soluiton(int n) {
        dy[0] = 0; dy[1] = 0;

        for (int i = 2; i <= n; i++) {
            dy[i] = dy[i-1] + 1;
            if (i % 2 == 0) dy[i] = Math.min(dy[i], dy[i / 2] + 1);
            if (i % 3 == 0) dy[i] = Math.min(dy[i], dy[i / 3] + 1);
        }

        return dy[n];
    }

    public static void main(String[] args) {
        Main T = new Main();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        dy = new int[n+1];

        System.out.println(T.soluiton(n));
    }
}
