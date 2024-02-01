import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }
        compress(0, 0, n, n);
        System.out.println(sb);
    }

    private static void compress(int x1, int y1, int x2, int y2) {
        // 크기가 1인 정사각형일 때 || 하나의 숫자로만 채워지 정사각형일 때
        int len = x2 - x1;
        if (len == 1 || isAllSameNumber(x1, y1, x2, y2)) {
            // 더 이상 분할할 필요 없으니, 해당 숫자 추가 후 return
            sb.append(arr[x1][y1]);
            return;
        }
        sb.append("(");
        compress(x1, y1, x1 + len / 2, y1 + len / 2); // (0,0) (4,4)
        compress(x1, y1 + len / 2, x1 + len / 2, y2); // (0,4) (4,8)
        compress(x1 + len / 2, y1, x2, y1 + len / 2); // (4,0) (8,4)
        compress(x1 + len / 2, y1 + len / 2, x2, y2); // (4,4) (8,8)
        sb.append(")");
    }

    private static boolean isAllSameNumber(int x1, int y1, int x2, int y2) {
        int number = arr[x1][y1];
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (arr[i][j] != number) return false;
            }
        }
        return true;
    }
}
