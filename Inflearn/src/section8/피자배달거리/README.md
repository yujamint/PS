# 피자 배달 거리(삼성 SW역량평가 기출문제 : DFS활용)

## 문제
```
[설명]
N×N 크기의 도시지도가 있습니다. 도시지도는 1×1크기의 격자칸으로 이루어져 있습니다.

각 격자칸에는 0은 빈칸, 1은 집, 2는 피자집으로 표현됩니다. 각 격자칸은 좌표(행번호, 열 번호)로 표현됩니다.

행번호는 1번부터 N번까지이고, 열 번호도 1부터 N까지입니다.

도시에는 각 집마다 “피자배달거리”가 았는데 각 집의 피자배달거리는 해당 집과 도시의 존재하는

피자집들과의 거리 중 최소값을 해당 집의 “피자배달거리”라고 한다.

집과 피자집의 피자배달거리는 |x1-x2|+|y1-y2| 이다.

예를 들어, 도시의 지도가 아래와 같다면
```
![Image](https://cote.inflearn.com/public/upload/15230e4e41.jpg)
```
(1, 2)에 있는 집과 (2, 3)에 있는 피자집과의 피자 배달 거리는 |1-2| + |2-3| = 2가 된다.

최근 도시가 불경기에 접어들어 우후죽순 생겼던 피자집들이 파산하고 있습니다.

도시 시장은 도시에 있는 피자집 중 M개만 살리고 나머지는 보조금을 주고 폐업시키려고 합니다.

시장은 살리고자 하는 피자집 M개를 선택하는 기준으로 도시의 피자배달거리가 최소가 되는 M개의 피자집을 선택하려고 합니다.

도시의 피자 배달 거리는 각 집들의 피자 배달 거리를 합한 것을 말합니다.


[입력]
첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 12)이 주어진다.

둘째 줄부터 도시 정보가 입력된다.


[출력]
첫째 줄에 M개의 피자집이 선택되었을 때 도시의 최소 피자배달거리를 출력한다.
```
```
예시 입력 1 
4 4
0 1 2 0
1 0 2 1
0 2 1 2
2 0 1 2

예시 출력 1
6
```

**첫 번째 풀이방법**
- 도시 정보를 입력받으며, 집과 피자가게의 좌표를 ArrayList에 각각 저장한다.(pizza, home)
- 조합을 구할 때와 같이, 한 레벨마다 어떤 피자가게를 뺄지 정한 뒤에 재귀호출을 통해 다음 레벨로 넘어간다.
  - 피자가게가 없어진 것을 도시정보에 반영하기 위해 arr[i][j] = 0으로 만든다
  - 재귀호출이 끝나면 또 다른 조합을 만들기 위해 원래 상태로 되돌려놓는다. (arr[i][j] = 2)
- 이를 (피자가게 수 - m)번만큼 실행하고 나면 빼야 되는 피자가게의 수만큼 뺀 것이므로 도시의 최소 피자배달거리를 구한다.
    - (피자가게 수 - m)개만큼의 피자가게를 뺀 것이므로 m개의 피자가게만 남아있는 것과 같다.
    - 각 집마다 가장 가까운 피자가게까지의 이동거리를 구하여 모두 더하는 문제이므로 BFS를 이용했다.
    - 집마다 피자가게까지의 최단거리를 BFS로 구한 뒤 모두 더한 것이 도시의 최소 피자배달거리
      - BFS에서 Queue에 좌표를 넣기 위해 Point 클래스 생성

위 방법으로 시도했을 때, 시간초과로 인해서 실패했다. BFS로 최단거리를 구한 것인데 왜 시간초과인지는 잘 모르겠다.

Code
```java
class Point{
    int x,y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n,m,dis=Integer.MAX_VALUE;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static ArrayList<Point> pizza = new ArrayList<>();
    static ArrayList<Point> home = new ArrayList<>();
    static Queue<Point> Q = new LinkedList<>();

    public void DFS(int L, int start){
        if(L==pizza.size()-m){
            int temp = 0;
            for(Point h : home) temp += BFS(h);
            dis = Math.min(dis, temp);
        }
        else {
            for(int i=start; i<pizza.size(); i++){
                Point tmp = pizza.get(i); // 피자 집 중 하나를 가져와서
                arr[tmp.x][tmp.y] = 0; // 없애고
                DFS(L+1, i+1); // 다음으로 없앨 피자집 정하기 위해 재귀호출
                arr[tmp.x][tmp.y] = 2; // 없앤 것 해제
            }
        }
    }

    public int BFS(Point h){
        Queue<Point> Q = new LinkedList<>();
        Q.offer(h);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++) {
                Point tmp = Q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if(arr[nx][ny] == 2) return L+1;
                        Q.offer(new Point(nx, ny));
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][n];
        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 2) pizza.add(new Point(i, j));
                else if(arr[i][j] == 1) home.add(new Point(i,j));
            }
        }
        T.DFS(0,0);
        System.out.println(dis);
    }
}
```

**강의 풀이방법**
- 도시 정보를 입력받을 때, 2차원 배열에 모든 도시 정보를 입력받지 않고, 피자가게와 집의 좌표만 ArrayList에 저장한다.
- 그리고 DFS에서 조합을 고를 때와 같은 원리로 m개의 피자가게를 고르고, 그 피자가게가 ArrayList의 몇 번째 인덱스인지 combi 배열에 저장한다.(남겨지는 피자가게)
- m개의 피자가게를 모두 고른 뒤에는 2중 for문을 통해 각 집마다의 피자배달거리를 구한다.
  - combi 배열을 이용해 남아있는 피자가게에 접근한다.
  - 외부 반복문 - 집 개수, 내부 반복문 - 남아있는 피자가게 수(m)
- 집마다의 피자배달거리를 모두 더해 도시의 최소 피자배달거리를 구한다.

**얻어갈 것**
- Point 클래스를 이용해 좌표를 저장하므로, 2차원 배열을 만들어서 모든 도시 정보를 저장할 필요는 없다.
- 첫 시도에는 최단거리를 구하기 위해 BFS를 사용했다.
  - 하지만, Point 클래스 객체에 저장되어 있는 집의 좌표와, 피자가게의 좌표를 이용해 거리를 더욱 쉽게 구할 수 있다.
    - BFS로 해결했을 때는 시간초과가 떴는데, 가지 않아도 되는 점을 가면서 최선의 길을 찾아가는 BFS의 특성상 좌표를 통해 거리를 구하는 방법보다 비효율적인 것 같다.
  - 결국, 2중 for문을 통해 거리를 구하는 것이 BFS보다 더욱 효율적이다.
- 좌표를 통해 거리를 구할 수 있을 때는 최단거리를 굳이 BFS로 구하려고 하지 말자!