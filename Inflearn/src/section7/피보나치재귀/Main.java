package section7.피보나치재귀;

import java.util.Scanner;

public class Main {
    static int[] fibo;
    public int DFS(int n){
        if(fibo[n]>0) return fibo[n];
        if (n<=2) return fibo[n] = 1;
        else return fibo[n] = DFS(n-1) + DFS(n-2);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fibo = new int[n+1];
        T.DFS(n);
        for (int i=1; i<=n; i++) System.out.print(fibo[i] + " ");
    }
}
