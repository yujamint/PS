package section7.재귀함수;

import java.util.Scanner;

public class Main {
    public void DFS(int n){
        if(n==0) return; // 재귀함수 사용할 때 초보자일 땐 if-else문 생각
        else {
            DFS(n - 1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m.DFS(n);
    }
}
