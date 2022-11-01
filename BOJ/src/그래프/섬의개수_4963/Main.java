package 그래프.섬의개수_4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int w, h, cnt;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static boolean[][] check;
    static int[][] map;

    public static void DFS(int x, int y) {
        check[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= h || nx < 0 || ny >= w || ny < 0) continue;

            if (map[nx][ny] == 0 || check[nx][ny]) continue;

            DFS(nx, ny);
        }
    }

    public static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        check[x][y] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= h || nx < 0 || ny >= w || ny < 0) continue;

                if (map[nx][ny] == 0 || check[nx][ny]) continue;

                queue.offer(new Point(nx, ny));
                check[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        String input;

        while (!(input = br.readLine()).equals("0 0")) {
            cnt = 0;
            st = new StringTokenizer(input, " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            check = new boolean[h][w];
            map = new int[h][w];

            for (int height = 0; height < h; height++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int width = 0; width < w; width++) {
                    map[height][width] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 0 || check[i][j]) continue;

                    BFS(i, j);
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}
