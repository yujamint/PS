package DP.타일링2xN_11726;

import java.util.Scanner;

public class Main {
    static int[] dy;

    private int recur(int n) {
        if(dy[n] > 0)return dy[n];
        if (n <= 2) return dy[n] = n;
        else return dy[n] = recur(n-2) + recur(n-1);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        dy = new int[n + 1];

        System.out.println(T.recur(n)%10007);
    }
}
