import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int EXTERNAL_AIR = -1;
    private static final int CHEESE = 1;
    static int n, m, cheeseCount = 0;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == CHEESE) cheeseCount++;
            }
        }

        int hours = 0;
        while (cheeseCount > 0) {
            external(0, 0);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == CHEESE) {
                        check(i, j);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] != CHEESE) board[i][j] = 0;
                }
            }
            hours++;
        }
        System.out.println(hours);
    }

    private static void check(int x, int y) {
        int externalAir = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (board[nx][ny] == EXTERNAL_AIR) {
                externalAir++;
            }
        }
        if (externalAir >= 2) {
            board[x][y] = 2;
            cheeseCount--;
        }
    }

    private static void external(int sx, int sy) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});
        board[sx][sy] = EXTERNAL_AIR;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (board[nx][ny] == 0) {
                    board[nx][ny] = EXTERNAL_AIR;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

}
