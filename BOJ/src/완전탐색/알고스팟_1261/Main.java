package 완전탐색.알고스팟_1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
    int x;
    int y;
    int count;

    public Point(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

    @Override
    public int compareTo(Point o) {
        return this.count - o.count;
    }
}

public class Main {
    static int n, m;
    static int[][] maze;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int BFS(int x, int y) {
        PriorityQueue<Point> queue = new PriorityQueue<>();

        queue.offer(new Point(x, y, 0));
        boolean[][] visited = new boolean[n + 1][m + 1];
        visited[x][y] = true;

        int nx;
        int ny;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            if (cur.x == n && cur.y == m) return cur.count;

            for (int i = 0; i < 4; i++) {
                nx = cur.x + dx[i];
                ny = cur.y + dy[i];

                if (nx < 1 || ny < 1 || nx > n || ny > m) continue;

                if (!visited[nx][ny] && maze[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny, cur.count + 1));
                }

                if (!visited[nx][ny] && maze[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny, cur.count));
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        maze = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                maze[i][j] = input.charAt(j - 1) - '0';
            }
        }
        System.out.println(BFS(1,1));
    }
}
