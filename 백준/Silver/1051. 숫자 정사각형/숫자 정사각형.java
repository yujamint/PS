import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = row.charAt(j) - '0';
            }
        }

        for (int size = Math.min(n, m); size > 0; size--) {
            for (int i = 0; i <= n - size; i++) {
                for (int j = 0; j <= m - size; j++) {
                    if (isValid(i, j, size)) {
                        System.out.println(size * size);
                        System.exit(0);
                    }
                }
            }
        }

    }

    private static boolean isValid(int x, int y, int size) {
        int num = arr[x][y];
        return arr[x + size - 1][y] == num && arr[x][y + size - 1] == num && arr[x + size - 1][y + size - 1] == num;
    }
}
