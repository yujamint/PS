package section8.미로최단거리통로;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
    int x;
    int y;
    public Point(int y, int x){
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int[] my = new int[]{0,1,0,-1};
    static int[] mx = new int[]{1,0,-1,0};
    // 3시, 6시, 9시, 12시 방향 순서

    static int[][] arr = new int[8][8]; // 인덱스를 1부터 7까지 사용하기 위해 배열 크기 8로 선언
    static Queue<Point> Q = new LinkedList<>();

    public int BFS(int L, int y, int x){
        Q.offer(new Point(y,x)); // 시작점 추가
        while(!Q.isEmpty()){
            int len = Q.size(); // Queue 크기
            for(int i=0; i<len; i++){ // 해당 Queue에 있는 원소 모두 꺼내기 위해 Queue 크기만큼 반복
                Point cur = Q.poll(); // 해당 레벨의 원소 꺼낸다.
                for(int j=0; j<4; j++){  // cur이 이동할 수 있는 모든 좌표를 확인한다.
                    int nx = cur.x + mx[j];
                    int ny = cur.y + my[j];
                    if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && arr[ny][nx] == 0) { // 이동 후보지 조건
                        //(1) x좌표와 y좌표가 1~7 사이 (2) 벽이 아니라 통로인 좌표 = 아직 지나지 않은 점
                        if(nx == 7 && ny == 7) return L+1; // 후보지 중에 목표지가 있다면 다음 레벨에 등장할 것이므로 (현재 레벨 + 1)
                        Q.offer(new Point(ny,nx)); // cur에서 이동 가능한 좌표들을 모두 Queue에 넣는다. 이 좌표들은 다음 레벨에서 위 과정을 반복할 것
                        arr[ny][nx] = 1; // 이동할 좌표이기 때문에 다시 되돌아오지 않도록 벽으로 처리한다.
                    }
                }
            }
            L++; // 해당 레벨의 원소 꺼내고, 그 원소의 이동 가능한 후보지까지 Queue에 모두 넣었다면 레벨 증가시키고 while문의 처음으로 돌아가서 반복한다.
        }
        return -1;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        for(int i=1; i<=7; i++){
            for(int j=1; j<=7; j++) arr[i][j] = sc.nextInt();
        }
        arr[1][1] = 1;
        System.out.println(T.BFS(0,1,1));
    }
}
