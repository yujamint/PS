package section7.송아지찾기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] ch;
    static int[] dis = {-1, 1, 5};
    Queue<Integer> Q = new LinkedList<>();

    public int BFS(int S, int E) {
        int L=0;
        ch[S]=1;
        Q.offer(S);
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i=0; i<len; i++){
                int x = Q.poll();
                for(int j=0; j<3; j++){
                    int nx = x + dis[j];
                    if(nx == E) return L+1;
                    if(nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
        }
        return L;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int E = sc.nextInt();
        ch = new int[10001];
        System.out.println(T.BFS(S,E));
    }
}
