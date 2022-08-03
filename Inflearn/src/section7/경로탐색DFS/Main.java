package section7.경로탐색DFS;

import java.util.Scanner;

public class Main {
    static int n,m,answer=0;
    static int[] ch;
    static int[][] graph;
    public void DFS(int v){
        if (v==n) answer++;
        else {
            for(int i=1; i<=n; i++){
                if(graph[v][i] == 1 && ch[i] == 0){
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 정점 개수
        m = sc.nextInt(); // 간선 개수
        graph = new int[n+1][n+1];
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        ch = new int[n+1];
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
