# 토마토(BFS 활용)

## 문제
```
[설명]
현수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다.

토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다.
```
![Image](https://cote.inflearn.com/public/upload/a9d513f5a5.jpg)
```
창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면,

익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.

하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며,

토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 현수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.

토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,

며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.


[입력]
첫 줄에는 상자의 크기를 나타내는 두 정수 M, N이 주어진다. M은 상자의 가로 칸의 수,

N 은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M, N ≤ 1,000 이다.

둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다.

즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다.

하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다.

정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.


[출력]
여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다.

만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고,

토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
```
```
예시 입력 1 
6 4
0 0 -1 0 0 0
0 0 1 0 -1 0
0 0 -1 0 0 0
0 0 0 0 -1 1

예시 출력 1
4
```

**내 풀이방법**
- 토마토는 인접한(상하좌우 1칸) 토마토 중에 익지 않은 토마토를 익게 할 수 있다.
- 그러므로 익은 토마토의 인접한 토마토에 접근하기 위해 방향 배열(dx,dy)을 만든다.
- 익은 토마토를 통해서 인접한 토마토에 접근하기 위해 Queue에 익은 토마토들의 위치를 모두 추가한다.
- 익은 토마토를 하나씩 꺼내서 인접한 토마토가 다음 조건을 만족하는지 검사한 후에, 만족한다면 해당 토마토들을 Queue에 추가한다.
    1. x좌표와 y좌표가 0~n-1 사이에 있다.
    2. 익지 않은 토마토이다.(arr[nx][ny] == 0)
- 이렇게 반복해가며 한 날짜(레벨)를 돌며 모든 인접한 토마토들을 추가한다.
- 날짜(레벨)를 증가시키고 위 과정에서 넣은 토마토들로 같은 과정을 반복하며 조건을 만족하고, 인접한 토마토들을 Queue에 추가한다.
- 인접한 토마토들을 익게 만들어가며 더 이상 익지 않은 토마토가 없다면 모든 토마토가 익는 데에 소요된 날짜를 반환하고, 모든 과정을 반복할 때까지도 익지 않은 토마토가 남아있다면 -1을 반환한다.

**강의 풀이방법**
- 각 토마토마다 익는 데에 소요된 날짜를 값으로 저장하는 dis 배열을 생성한다.
- 인접한 토마토를 익게 하는 과정은 똑같다.
  - 다만, dis 배열을 채우기 위해서, Queue에서 poll한 토마토와 인접한 토마토를 Queue에 추가하며 (poll 한 토마토가 익는 데에 걸리는 날짜 + 1)의 값을 dis 배열에 저장한다.
- 모든 과정을 실행한 뒤에 다음과 같이 처리한다.
    - 익지 않은 토마토가 남아있다면 -1을 반환한다.
    - 모든 토마토가 익었다면, 익는 데에 소요된 날짜가 가장 큰 토마토를 dis 배열에서 찾아서 출력한다.

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
	static int n, m;
	static Queue<Point> Q=new LinkedList<>();
	public void BFS(){
		while(!Q.isEmpty()){
			Point tmp=Q.poll();
			for(int i=0; i<4; i++){
				int nx=tmp.x+dx[i];
				int ny=tmp.y+dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny]==0){
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
		m=kb.nextInt();
		n=kb.nextInt();
		board=new int[n][m];
		dis=new int[n][m];
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				board[i][j]=kb.nextInt();
				if(board[i][j]==1) Q.offer(new Point(i, j));
			}
		}
		T.BFS();
		boolean flag=true;
		int answer=Integer.MIN_VALUE;
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(board[i][j]==0) flag=false;
			}
		}
		if(flag){
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					answer=Math.max(answer, dis[i][j]);
				}
			}
			System.out.println(answer);
		}
		else System.out.println(-1);
	}
}
```