package section8.합이같은부분집합;

import java.util.Scanner;

public class Main {
    static String answer = "NO";
    static int n, total=0;
    static boolean flag = false;
    static int[] arr;
    public void DFS(int L, int sum, int[] arr) {
        if(flag) return;
        if(sum > total-sum) return;
        if(L==n) {
            if(sum == total - sum) {
                answer = "YES";
                flag = true;
            }
        }
        else {
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i=0; i<n; i++) {
            int a = sc.nextInt();
            arr[i] = a;
            total+=a;
        }
        int sum = 0;
        T.DFS(0, sum, arr);
        System.out.println(answer);
    }
}
