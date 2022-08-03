package section8.수열추측하기;

import java.util.Scanner;

public class Main {
    static int n,f;
    static int[] ch, pm, cn;
    static int[][] mem = new int[11][11];
    static boolean flag = false;

    public int Combination(int n, int r){
        if(mem[n][r] > 0) return mem[n][r];
        if(r==0 || r==n) return 1;
        return mem[n][r] = Combination(n-1, r-1) + Combination(n-1,r);
    }
    public void DFS(int L, int sum){
        if(flag) return;
        if(sum > f) return;
        if(L==n) {
            if(sum == f){
                for(int x : pm) System.out.print(x + " ");
                flag = true;
            }
        }
        else {
            for(int i=1; i<=n; i++){
                if(ch[i]==0){
                    ch[i] = 1;
                    pm[L] = i;
                    DFS(L+1, sum+ (pm[L]*cn[L]));
                    ch[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        ch = new int[n+1]; // 순열 만들 때 중복 체크 1~n
        pm = new int[n]; // 순열 0~n-1
        cn = new int[n]; // (n-1)Cr 값 들어있는 배열 0~n-1
        for(int i=0; i<n; i++){
            cn[i] = T.Combination(n-1,i);
        }
        T.DFS(0, 0);
    }
}
