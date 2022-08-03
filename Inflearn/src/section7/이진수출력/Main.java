package section7.이진수출력;

import java.util.Scanner;

public class Main {
    public void DFS(int n){
        if(n == 0) return;
        else{
            DFS(n/2);
            System.out.print(n%2);
        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        T.DFS(n);
    }
}
