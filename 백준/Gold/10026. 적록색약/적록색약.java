import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static char[][] map;
    static boolean[][] aVisited;
    static boolean[][] bVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        aVisited = new boolean[n][n];
        bVisited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        int a = 0;
        int b = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!aVisited[i][j]) {
                    normal(i, j, map[i][j]);
                    a++;
                }
                if (!bVisited[i][j]) {
                    blind(i, j, map[i][j]);
                    b++;
                }
            }
        }

        System.out.println(a + " " + b);
    }

    private static void normal(int sx, int sy, char color) {
        Queue<int[]> queue = new LinkedList<>();
        aVisited[sx][sy] = true;
        queue.offer(new int[]{sx, sy});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (aVisited[nx][ny] || map[nx][ny] != color) continue;
                queue.offer(new int[]{nx, ny});
                aVisited[nx][ny] = true;
            }
        }
    }

    private static void blind(int sx, int sy, char color) {
        Queue<int[]> queue = new LinkedList<>();
        bVisited[sx][sy] = true;
        queue.offer(new int[]{sx, sy});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (bVisited[nx][ny]) continue;
                if ((color == 'R' || color == 'G')) {
                    if (map[nx][ny] == 'B') continue;
                } else {
                    if (map[nx][ny] != color) continue;
                }
                queue.offer(new int[]{nx, ny});
                bVisited[nx][ny] = true;
            }
        }
    }
}
