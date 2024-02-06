import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int mod = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long[][] matrix = new long[2][2];
        matrix[0][0] = 1;
        matrix[0][1] = 1;
        matrix[1][0] = 1;
        matrix[1][1] = 0;

        if (n < 2) {
            System.out.println(1);
            return;
        }

        long[][] res = pow(matrix, n - 1);
        System.out.println(res[0][0]);
    }

    private static long[][] pow(long[][] matrix, long exponent) {
        if (exponent == 1) return matrix;

        long[][] temp = pow(matrix, exponent / 2);
        long[][] temp2 = multiply(temp, temp);
        if (exponent % 2 == 1) return multiply(temp2, matrix);
        else return temp2;
    }

    private static long[][] multiply(long[][] matrix1, long[][] matrix2) {
        long[][] matrix = new long[2][2];

        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                long sum = 0;
                for (int i = 0; i < 2; i++) {
                    long num1 = matrix1[row][i];
                    long num2 = matrix2[i][col];
                    sum = (sum + num1 * num2) % mod;
                }
                matrix[row][col] = sum % mod;
            }
        }
        return matrix;
    }
}

