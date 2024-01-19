import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board = new int[9][9];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(input.nextToken());
                board[i][j] = num;
            }
        }
        DFS(0, 0);
    }

    private static void DFS(int row, int col) {
        // 행에 빈 칸이 없을 때, 다음 행으로 넘언간다.
        if (col == 9) {
            DFS(row + 1, 0);
            return;
        }

        // 모든 행을 다 채우면 끝낸다.
        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        // 빈 칸이 아니면 넘어간다.
        if (board[row][col] != 0) {
            DFS(row, col + 1);
            return;
        }

        // 빈 칸이라면 가능한 숫자를 찾는다.
        for (int i = 1; i <= 9; i++) {
            if (!isPossible(row, col, i)) continue;
            board[row][col] = i;
            DFS(row, col + 1);
        }
        board[row][col] = 0;
    }

    private static boolean isPossible(int row, int col, int val) {
        // 같은 행에 겹치는 숫자가 있는지 검사
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) return false;
        }

        //같은 열에 겹치는 숫자가 있는지 검사
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val) return false;
        }

        int xBase = 3 * (row / 3);
        int yBase = 3 * (col / 3);
        for (int i = xBase; i < xBase + 3; i++) {
            for (int j = yBase; j < yBase + 3; j++) {
                if (board[i][j] == val) return false;
            }
        }

        return true;
    }
}
