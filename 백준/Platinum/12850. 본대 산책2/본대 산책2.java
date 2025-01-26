import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
    0. 정보과학관
    1. 전산관
    2. 미래관
    3. 신양관
    4. 한경직기념관
    5. 진리관
    6. 형남공학관
    7. 학생회관
     */

    private static final int MOD = 1_000_000_007;
    static long[][] matrix = {
            {0, 1, 1, 0, 0, 0, 0, 0},
            {1, 0, 1, 1, 0, 0, 0, 0},
            {1, 1, 0, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 1, 0, 0},
            {0, 0, 1, 1, 0, 1, 1, 0},
            {0, 0, 0, 1, 1, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 1, 0},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] res = doPow(n);
        System.out.println(res[0][0] % MOD);
    }

    private static long[][] doPow(int n) {
        if (n == 1) {
            return matrix;
        }

        long[][] temp = doPow(n / 2);
        temp = multiply(temp, temp);

        if (n % 2 == 1) {
            temp = multiply(temp, matrix);
        }

        return temp;
    }

    private static long[][] multiply(long[][] a, long[][] b) {
        long[][] temp = new long[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    temp[i][j] = (temp[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }

        return temp;
    }
}
