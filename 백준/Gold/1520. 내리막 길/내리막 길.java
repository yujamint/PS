import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr, dp;
    static boolean[][] ch;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];
        ch = new boolean[n + 1][m + 1];
        dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(DFS(1, 1));
    }
    private static int DFS(int x, int y) {
        if (x == n && y == m) {
            return 1;
        }
        if (ch[x][y]) {
            return dp[x][y];
        }
        ch[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx > n || nx <= 0 || ny > m || ny <= 0) continue;

            if (arr[x][y] > arr[nx][ny]) {
                dp[x][y] += DFS(nx, ny);
            }

        }
        return dp[x][y];
    }
}
