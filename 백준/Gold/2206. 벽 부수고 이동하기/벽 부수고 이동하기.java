import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pair {
        int x;
        int y;
        boolean isWallBreaker;
        int count;

        public Pair(int x, int y, boolean isWallBreaker, int count) {
            this.x = x;
            this.y = y;
            this.isWallBreaker = isWallBreaker;
            this.count = count;
        }
    }

    static int n, m;
    static boolean[][] visited2;
    static boolean[][] visited1;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited1 = new boolean[n][m];
        visited2 = new boolean[n][m];
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }
        System.out.println(BFS(0, 0));
    }

    private static int BFS(int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y, false, 1));
        visited1[x][y] = true;
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            if (cur.x == n - 1 && cur.y == m - 1) {
                return cur.count;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= n || ny >= m || nx < 0 || ny < 0) continue;

                // 막혀 있지 않은 길이라면
                if (arr[nx][ny] == 0) {
                    // 지나간다.
                    if (cur.isWallBreaker && !visited2[nx][ny]) {
                        visited2[nx][ny] = true;
                        queue.offer(new Pair(nx, ny, cur.isWallBreaker, cur.count + 1));
                    }
                    if (!cur.isWallBreaker && !visited1[nx][ny]){
                        visited1[nx][ny] = true;
                        queue.offer(new Pair(nx, ny, cur.isWallBreaker, cur.count + 1));
                    }
                }
                // 막혀 있는 길일 때
                else {
                    // 벽을 부순 적이 없다면
                    if (cur.isWallBreaker || visited2[nx][ny]) continue;
                    // 벽을 부수고 간다.
                    visited2[nx][ny] = true;
                    queue.offer(new Pair(nx, ny, true, cur.count + 1));
                }
            }
        }
        return -1;
    }
}