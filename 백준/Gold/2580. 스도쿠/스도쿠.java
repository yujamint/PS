import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] puzzle = new int[10][10];

    public static boolean possibility(int row, int column, int value) {

        for (int i = 1; i <= 9; i++) {
            if (puzzle[row][i] == value) return false;
        }

        for (int i = 1; i <= 9; i++) {
            if (puzzle[i][column] == value) return false;
        }

        int box_row = ( (row-1) / 3) * 3 + 1;
        int box_column = ( (column-1) / 3) * 3 + 1;

        for (int i = box_row; i < box_row + 3; i++) {
            for (int j = box_column; j < box_column + 3; j++) {
                if (puzzle[i][j] == value) return false;
            }
        }

        return true;
    }

    public static void sudoku(int row, int column) {
        if (column == 10) {
            sudoku(row + 1, 1);
            return;
        }

        if (row == 10) {
            StringBuilder sb = new StringBuilder("");

            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    sb.append(puzzle[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb.toString());

            System.exit(0);
        }

        if (puzzle[row][column] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (possibility(row,column,i)) {
                    puzzle[row][column] = i;
                    sudoku(row, column + 1);
                }
            }
            puzzle[row][column] = 0;
            return;
        }

        sudoku(row, column + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= 9; j++) {
                puzzle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(1, 1);
    }
}