package 완전탐색.알고스팟_1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, answer = Integer.MAX_VALUE;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void DFS(int x, int y, int count) {
        if (count >= answer) return;
        if (x == m && y == n) {
            answer = Math.min(answer, count);
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 1 && nx <= m && ny >= 1 && ny <= n) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        if (maze[nx][ny] == 1) DFS(nx, ny, count + 1);
                        else DFS(nx, ny, count);
                        visited[nx][ny] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[m + 1][n + 1];
        visited = new boolean[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            String input = br.readLine();
            for (int j = 1; j <= n; j++) {
                maze[i][j] = input.charAt(j - 1) - '0';
            }
        }

        visited[1][1] = true;
        DFS(1, 1, 0);
        System.out.println(answer);
    }
}
