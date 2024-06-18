import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] sudoku;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = input.charAt(j) - '0';
            }
        }

        DFS(0, 0);
    }

    private static void DFS(int x, int y) {
        if (flag) return;
        if (y == 9) {
            x++;
            y = 0;
        }
        if (x >= 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]);
                }
                sb.append('\n');
            }
            System.out.println(sb);
            flag = true;
            return;
        }
        if (sudoku[x][y] != 0) {
            DFS(x, y + 1);
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (check(x, y, i)) {
                sudoku[x][y] = i;
                DFS(x, y + 1);
                sudoku[x][y] = 0;
            }
        }
    }

    private static boolean check(int x, int y, int val) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[x][i] == val || sudoku[i][y] == val) {
                return false;
            }
        }
        int startX = x - x % 3;
        int startY = y - y % 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (sudoku[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

}
