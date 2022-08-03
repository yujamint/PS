package section8.미로탐색;

import java.util.Scanner;

public class Main {
    static int answer=0;
    static int[] my = new int[]{0,1,0,-1};
    static int[] mx = new int[]{1,0,-1,0};
    // 3시, 6시, 9시, 12시 방향 순서

    static int[][] arr = new int[8][8];


    public void DFS(int y, int x){
        if(x == 7 && y == 7) // 목적지에 도착했을 때
            answer++; // 경우의 수 증가
        else {
            for(int i=0; i<4; i++) {
                int nx = x + mx[i];
                int ny = y + my[i];
                if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && arr[ny][nx] == 0) { // 가려고 하는 곳의 x,y 좌표가 1~7 사이이며, 벽이 아니라면
                        arr[ny][nx] = 1; // 다시 못 돌아가도록 벽으로 만들어놓고
                        DFS(ny, nx); // 간다
                        arr[ny][nx] = 0; // 함수 끝났으면 다시 갈 수 있도록 통로로 만든다.
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<8; i++){
            arr[0][i] = 1;
            arr[i][0] = 1;
        }
        for(int i=1; i<=7; i++){
            for(int j=1; j<=7; j++) arr[i][j] = sc.nextInt();
        }
        arr[1][1] = 1;
        T.DFS(1,1);
        System.out.println(answer);
    }
}
