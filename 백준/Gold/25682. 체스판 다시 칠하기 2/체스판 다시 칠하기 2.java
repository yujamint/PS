import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = input.charAt(j - 1);
            }
        }
        int[][] sum = new int[n + 1][m + 1];
        char block = 'B';
        for (int row = 1; row <= n; row++) {
            char rowBlock = block;
            for (int col = 1; col <= m; col++) {
                if (arr[row][col] != rowBlock) sum[row][col] = sum[row][col - 1] + 1;
                else sum[row][col] = sum[row][col - 1];
                rowBlock = rowBlock == 'B' ? 'W' : 'B';
            }
            block = block == 'B' ? 'W' : 'B';
        }

        for (int col = 1; col <= m; col++) {
            for (int row = 1; row <= n; row++) {
                sum[row][col] += sum[row - 1][col];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int row = k; row <= n; row++) {
            for (int col = k; col <= m; col++) {
                int squareSum = 0;
                squareSum += sum[row][col] - sum[row][col - k] - sum[row - k][col] + sum[row - k][col - k];
                squareSum = Math.min(squareSum, k * k - squareSum);
                min = Math.min(min, squareSum);
            }
        }
        System.out.println(min);
    }
}
