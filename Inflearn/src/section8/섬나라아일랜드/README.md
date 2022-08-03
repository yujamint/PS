# 섬나라 아일랜드

## 문제
```
[설명]
N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.

각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.

섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.
```
![Image](https://cote.inflearn.com/public/upload/7c81fe29cd.jpg)
```
만약 위와 같다면 섬의 개수는 5개입니다.


[입력]
첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.

두 번째 줄부터 격자판 정보가 주어진다.


[출력]
첫 번째 줄에 섬의 개수를 출력한다.
```
```
예시 입력 1 
7
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0

예시 출력 1
5
```

**첫 번째 풀이방법(BFS)**
1. 섬이 시작되는 점을 찾기 위해 2중 for문을 통해 map[i][j] == 1일 때를 찾는다.
2. 해당 점을 Queue에 넣는다.
   - Queue에 좌표를 저장하기 위해 Point 클래스를 생성한다.
3. Queue에서 좌표 tmp를 꺼내고 tmp와 8방향으로 인접한 점 중에 다음 조건을 만족하는 점을 Queue에 추가한다.
    1. x좌표와 y좌표가 0~n-1 사이에 위치한다.
    2. 바다가 아닌 섬으로 이어져있어야 하므로, map[nx][ny] == 1
4. 조건을 만족하는 모든 점을 Queue에 넣으면서 다시 되돌아가지 않도록 map에서의 값을 0으로 만들어준다. 3번 과정을 반복한다. 
5. 인접한 점 중에 조건을 만족하는 점이 없어지는 순간이 되면 해당 섬에 대한 함수를 모두 마치며 모든 좌표를 0으로 만든 것이다.

Code
```java
public class Main {
    static int n, island = 0;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1}; // 12시, 1.5시, 3시, 4.5시, 6시, 7,5시, 9시, 10.5시 방향 순서
    static int[][] map;
    static Queue<Point> Q = new LinkedList<>();

    public void BFS() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    Q.offer(new Point(i, j));
                    while(!Q.isEmpty()) {
                        int len = Q.size();
                        for(int s = 0 ; s<len; s++) {
                            Point tmp = Q.poll();
                            for (int k = 0; k < 8; k++) {
                                int nx = tmp.x + dx[k];
                                int ny = tmp.y + dy[k];
                                if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 1) {
                                    map[nx][ny] = 0;
                                    Q.offer(new Point(nx, ny));
                                }
                            }
                        }
                    }
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
        T.BFS();
        System.out.println(island);
    }
}
```

**강의 풀이방법(BFS)**
- 섬이 시작하는 지점을 찾기 위해 2중 for문을 돌리며 map[i][j] == 1인 부분을 찾는 과정을 함수로 분리하였다.
- map[i][j]==1인 지점을 찾으면 해당 지점을 BFS 함수에 인자로 넘기며, 섬 각각에 대해서 BFS를 호출하였다.
- 한 함수에 모든 과정을 넣으려 하다보니 지저분하다는 생각을 했는데, 분리할 수 있는 부분은 분리하도록 해야겠다.


**강의 풀이방법(DFS)**
- BFS와 방법은 거의 똑같다.
- 좌표를 Queue에 저장하기 위한 Point 객체를 사용하지 않는다.
- Queue를 만들지 않고, 섬이 이어지는 좌표를 DFS 함수로 넘겨줌으로써 섬이 완성될 때까지 계속해서 재귀호출을 한다는 차이가 있다.

**얻어갈 것**
- 한 함수에서 모든 걸 구현하려고 하지 말자
- DFS = 재귀호출, BFS = while문으로 큐 돌리고 넣고~