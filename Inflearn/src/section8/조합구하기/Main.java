package section8.조합구하기;

import java.util.Scanner;

public class Main {
    static int n,m;
    static int[] p;

    public void DFS(int L, int start){
        if(L==m){
            for(int x : p) System.out.print(x + " ");
            System.out.println();
        }
        else {
            for(int i=start; i<=4; i++){
                p[L] = i;
                DFS(L+1, i+1);
            }
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc= new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        p = new int[m];
        T.DFS(0,1);
    }
}
