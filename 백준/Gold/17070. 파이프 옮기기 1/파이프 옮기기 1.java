import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;
    private static final int DIAGONAL = 2;

    static int n, count = 0;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 1, HORIZONTAL);
        System.out.println(count);
    }

    private static void DFS(int x, int y, int direction) {
        if (x >= n || y >= n || board[x][y] == 1) return;
        if (direction == DIAGONAL && (board[x - 1][y] == 1 || board[x][y - 1] == 1)) return;
        if (x == n - 1&& y == n - 1) {
            count++;
            return;
        }
        switch (direction) {
            case HORIZONTAL:
                DFS(x, y + 1, HORIZONTAL);
                DFS(x + 1, y + 1, DIAGONAL);
                break;
            case VERTICAL:
                DFS(x + 1, y, VERTICAL);
                DFS(x + 1, y + 1, DIAGONAL);
                break;
            case DIAGONAL:
                DFS(x, y + 1, HORIZONTAL);
                DFS(x + 1, y, VERTICAL);
                DFS(x + 1, y + 1, DIAGONAL);
                break;
        }
    }

}
