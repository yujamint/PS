package 그래프.미로탐색_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;
    int L;

    public Point(int x, int y, int L) {
        this.x = x;
        this.y = y;
        this.L = L;
    }
}

public class Main {
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        String input;
        for (int i = 0; i < n; i++) {
            input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.print(BFS(0, 0));
    }

    public static int BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y, 1));

        while (!queue.isEmpty()) {

            Point cur = queue.poll();
            int cx = cur.x;
            int cy = cur.y;
            int L = cur.L;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= n || ny >= m || nx < 0 || ny < 0) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    continue;
                }

                if (nx == n - 1 && ny == m - 1) {
                    return L + 1;
                }

                map[nx][ny] = 0;
                queue.offer(new Point(nx, ny, L+1));
            }
        }

        return -1;
    }
}
