package section8.토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Tomato{
    int x;
    int y;
    public Tomato(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n,m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1}; // 12시, 3시, 6시, 9시 방향 순서
    static int[][] arr;
    static Queue<Tomato> Q = new LinkedList<>();

    public int BFS(int L){
        while(!Q.isEmpty()){
            boolean flag = true;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(arr[i][j] == 0) flag = false; // 익지 않은 토마토 개수 세기
                }
            }
            if(flag) return L; // 모든 토마토가 익었다면, 토마토가 익을 때까지 소요된 날짜 return
            int len = Q.size();
            for(int i=0; i<len; i++){
                Tomato tmp = Q.poll();
                for(int j=0; j<4; j++){
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0){
                        arr[nx][ny] = 1;
                        Q.offer(new Tomato(nx,ny));
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 1) Q.offer(new Tomato(i,j));
            }
        }
        System.out.println(T.BFS(0));
    }
}
