import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Tomato {
        int row;
        int col;
        int dim;
        int count;

        public Tomato(int row, int col, int dim, int count) {
            this.row = row;
            this.col = col;
            this.dim = dim;
            this.count = count;
        }
    }

    static boolean[][][] visited;
    static int[][][] tomatoes;
    static int[] dRow = {0, 0, 0, 0, 1, -1};
    static int[] dCol = {0, 0, -1, 1, 0, 0};
    static int[] dDim = {1, -1, 0, 0, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        tomatoes = new int[h][n][m];
        visited = new boolean[h][n][m];
        Queue<Tomato> queue = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    tomatoes[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomatoes[i][j][k] == 1) {
                        queue.offer(new Tomato(j, k, i, 0));
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        int max = 0;
        while (!queue.isEmpty()) {
            Tomato cur = queue.poll();
            max = Math.max(max, cur.count);

            for (int i = 0; i < 6; i++) {
                int nRow = cur.row + dRow[i];
                int nCol = cur.col + dCol[i];
                int nDim = cur.dim + dDim[i];
                if (nDim >= h || nRow >= n || nCol >= m || nDim < 0 || nRow < 0 || nCol < 0) continue;

                if (!visited[nDim][nRow][nCol] && tomatoes[nDim][nRow][nCol] == 0) {
                    queue.offer(new Tomato(nRow, nCol, nDim, cur.count + 1));
                    visited[nDim][nRow][nCol] = true;
                    tomatoes[nDim][nRow][nCol] = 1;
                }

            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomatoes[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(max);
    }

}
