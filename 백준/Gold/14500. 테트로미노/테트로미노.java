import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, res = Integer.MIN_VALUE;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                DFS(i, j, 0, 0);
                special(i, j);
            }
        }
        System.out.println(res);
    }

    private static void special(int x, int y) {
        // 가운데 기준
        // ㅗ
        if (x > 0 && y > 0 && y < m - 1) {
            res = Math.max(res, board[x][y] + board[x][y - 1] + board[x][y + 1] + board[x - 1][y]);
        }
        // ㅏ
        if (x > 0 && x < n - 1 && y < m - 1) {
            res = Math.max(res, board[x][y] + board[x - 1][y] + board[x + 1][y] + board[x][y + 1]);
        }
        // ㅜ
        if (x < n - 1 && y > 0 && y < m - 1) {
            res = Math.max(res, board[x][y] + board[x][y - 1] + board[x][y + 1] + board[x + 1][y]);
        }
        // ㅓ
        if (x > 0 && x < n - 1 && y > 0) {
            res = Math.max(res, board[x][y] + board[x - 1][y] + board[x + 1][y] + board[x][y - 1]);
        }
    }

    private static void DFS(int x, int y, int cnt, int sum) {
        if (cnt == 4) {
            res = Math.max(res, sum);
            return;
        }
        visited[x][y] = true;
        sum += board[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;
            DFS(nx, ny, cnt + 1, sum);
        }
        visited[x][y] = false;
    }

}
