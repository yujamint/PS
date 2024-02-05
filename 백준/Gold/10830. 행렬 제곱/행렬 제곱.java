import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int mod = 1_000, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) % mod;
            }
        }
        int[][] res = pow(arr, B);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(res[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] pow(int[][] arr, long exponent) {
        if (exponent == 1) return arr;

        int[][] temp = pow(multiplyMatrix(arr, arr), exponent / 2);
        if (exponent % 2 == 0) return temp;
        else return multiplyMatrix(arr, temp);
    }

    private static int[][] multiplyMatrix(int[][] arr1, int[][] arr2) {
        int[][] arr = new int[N][N];
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    int num1 = arr1[row][j];
                    int num2 = arr2[j][col];
                    sum = (sum + num1 * num2) % mod;
                }
                arr[row][col] = sum % mod;
            }
        }
        return arr;
    }
}
