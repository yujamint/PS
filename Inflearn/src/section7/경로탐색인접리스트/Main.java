package section7.경로탐색인접리스트;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n,m,answer=0;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public void DFS(int v){
        if (v == n) answer++;
        else {
            for(int nv : graph.get(v)){
                if(ch[nv] == 0){
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<Integer>());
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        ch = new int[n+1];
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
