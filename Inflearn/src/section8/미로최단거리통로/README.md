# 미로의 최단거리 통로(BFS)

## 문제
```
[설명]
7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요.

경로의 길이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미한다.

출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 도로이다.

격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
```
![Image](https://cote.inflearn.com/public/upload/88ff3b120f.jpg)
```
위와 같은 경로가 최단 경로의 길이는 12이다.


[입력]
첫 번째 줄부터 7*7 격자의 정보가 주어집니다.


[출력]
첫 번째 줄에 최단으로 움직인 칸의 수를 출력한다. 도착할 수 없으면 -1를 출력한다.
```
```
예시 입력 1 
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 1 0 0 0
1 0 0 0 1 0 0
1 0 1 0 0 0 0

예시 출력 1
12
```

**첫 번째 풀이방법**
- 큐에 시작점(1,1)을 넣은 뒤 레벨마다 다음 과정을 실행한다.
    - 큐에 있는 좌표를 꺼낸다.
    - 꺼낸 좌표(cur)에서 이동 가능한 좌표들을 for문을 통해 구한다.
    - 이동 가능한 좌표가 다음 조건을 만족하는지 검사한다.
        1. x좌표와 y좌표 모두 1과 7 사이에 위치한다.
        2. 해당 좌표가 통로로 이루어져있다.(arr[ny][nx] == 0)
        3. 해당 좌표를 아직 지나지 않았다.
            - 이 조건은 지나온 좌표를 벽으로 만들어줄 것이기 때문에 arr[ny][nx] == 0 이라면 만족하는 것이다.
    - 위 조건을 모두 만족하는, cur에서 이동 가능한 좌표를 큐에 추가한다.
        - 이동할 좌표이므로, 나중에 다시 되돌아가지 않도록 벽으로 만들어준다.(arr[ny][nx] = 1)
- 위 과정을 해당 레벨에 있던 좌표를 모두 꺼낼 때까지 반복한다.
- 모든 좌표를 꺼내고 그 좌표의 이동 가능한 좌표를 Queue에 추가했다면 레벨을 증가시키고 새로 추가한 좌표들에 대해 같은 과정을 실행한다.
- 위 과정을 반복하다가 cur에서 이동 가능한 좌표 중 목적지(7,7)가 있다면 (cur이 속한 레벨 + 1)을 리턴하며 함수를 종료한다.
    - 최단거리 통로의 길이를 구하는 문제이기 때문에 목적지 직전 좌표인 cur까지의 길이에 1을 더한 것이 최단거리 통로의 길이다.

**강의 풀이방법**
- 레벨을 사용하지 않고, 각 좌표까지의 거리를 원소로 가지는 dis 배열을 만들어서 마지막에 목적지까지의 거리(dis[7][7])를 출력한다

목적지의 거리를 찾자마자 메소드를 끝내지 않는다는 점에서 의문이 생겼다.
만약 모든 점까지의 거리를 알아야 되는 문제 상황이라면 좋은 방법이지만, 최단거리 통로의 길이만을 필요로 하는 이 문제에서는 효율적인지 잘 모르겠다.
그래도 거리 배열을 만든다는 점은 알고 있도록 해야겠다.

Code
```java
import java.util.*;
class Point{
    public int x, y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
class Main {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    static int[][] board, dis;
    public void BFS(int x, int y){
        Queue<Point> Q=new LinkedList<>();
        Q.offer(new Point(x, y));
        board[x][y]=1;
        while(!Q.isEmpty()){
            Point tmp=Q.poll();
            for(int i=0; i<4; i++){
                int nx=tmp.x+dx[i];
                int ny=tmp.y+dy[i];
                if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && board[nx][ny]==0){
                    board[nx][ny]=1;
                    Q.offer(new Point(nx, ny));
                    dis[nx][ny]=dis[tmp.x][tmp.y]+1;
                }
            }
        }
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        board=new int[8][8];
        dis=new int[8][8];
        for(int i=1; i<=7; i++){
            for(int j=1; j<=7; j++){
                board[i][j]=kb.nextInt();
            }
        }
        T.BFS(1, 1);
        if(dis[7][7]==0) System.out.println(-1);
        else System.out.println(dis[7][7]);
    }
}
```

**얻어갈 것**
- 거리 배열을 만드는 센스