package section8.바둑이승차;

import java.util.Scanner;

// 트럭 최대 수용 가능 무게 : C / 강아지 수 : N / 강아지 무게 : W
public class Main {
    static int sum = 0, max = Integer.MIN_VALUE;
    static int c,n;
    public void DFS(int L, int sum, int[] arr){
        if(sum > c) return;
        if(L == n) max = Math.max(sum,max);
        else {
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        T.DFS(0, sum, arr);
        System.out.println(max);
    }
}
