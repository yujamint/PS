package section8.섬나라아일랜드;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, island = 0;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1}; // 12시, 1.5시, 3시, 4.5시, 6시, 7,5시, 9시, 10.5시 방향 순서
    static int[][] map;
    static Queue<Point> Q = new LinkedList<>();

    public void BFS(){
        while(!Q.isEmpty()){
            Point tmp = Q.poll();
            for(int i=0; i<8; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 1){
                    map[nx][ny] = 0;
                    Q.offer(new Point(nx,ny));
                }
            }
        }
    }

    public void solutionBFS(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1) {
                    island++;
                    map[i][j] = 0;
                    Q.offer(new Point(i,j));
                    BFS();
                }
            }
        }
    }

    public void DFS(int x, int y){
        for(int i=0; i<8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 1){
                map[nx][ny] = 0;
                DFS(nx, ny);
            }
        }
    }

    public void solutionDFS(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1) {
                    map[i][j] = 0;
                    DFS(i,j);
                    island++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        T.solutionDFS();
        System.out.println(island);
    }
}
