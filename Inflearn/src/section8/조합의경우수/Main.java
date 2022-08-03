package section8.조합의경우수;

import java.util.Scanner;

public class Main {
    int[][] dy = new int[35][35]; // 메모이제이션
    public int solution(int n, int r) {
        if(dy[n][r] > 0) return dy[n][r];
        if(r == 0 || r == n) return 1;
        return dy[n][r] = solution(n-1, r-1) + solution(n-1, r);
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(T.solution(n,r));
    }
}
