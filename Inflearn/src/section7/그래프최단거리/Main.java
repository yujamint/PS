package section7.그래프최단거리;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] ch;
    static int[] dis;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public void DFS(int v) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(v);
        while (!Q.isEmpty()) {
            int cv = Q.poll();
            for (int nv : graph.get(cv)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    dis[nv] = dis[cv] + 1;
                    Q.offer(nv);
                }
            }

        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<Integer>());
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        dis = new int[n + 1];
        dis[1] = 0;
        ch = new int[n + 1];
        ch[1] = 1;
        T.DFS(1);
        for (int i = 2; i <= n; i++) System.out.println(i + " : " + dis[i]);
    }
}
