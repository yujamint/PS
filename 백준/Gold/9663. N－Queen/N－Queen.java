import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] columnVisited;
    static boolean[] columnPlusRow;
    static boolean[] columnMinusRow;

    static boolean[][] visited;
    static int n, answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        columnVisited = new boolean[n + 1];
        columnPlusRow = new boolean[2 * n - 1];
        columnMinusRow = new boolean[2 * n - 1];
        visited = new boolean[n + 1][n + 1];
        DFS(0, 1);
        System.out.println(answer);
    }

    private static void DFS(int count, int row) {
        if (count == n) {
            answer++;
            return;
        }
    
        for (int col = 1; col <= n; col++) {
            // col + row 범위 -> 2 ~ 2 * n
            // col - row 범위 -> -(n - 1) ~ n - 1
            if (columnVisited[col] || columnPlusRow[col + row - 2] || columnMinusRow[col - row + (n - 1)]) continue;
            columnVisited[col] = true;
            columnPlusRow[col + row - 2] = true;
            columnMinusRow[col - row + (n - 1)] = true;
            DFS(count + 1, row + 1);
            columnVisited[col] = false;
            columnPlusRow[col + row - 2] = false;
            columnMinusRow[col - row + (n - 1)] = false;
        }
    }
}
