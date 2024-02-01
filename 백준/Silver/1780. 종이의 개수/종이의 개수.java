import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[] numberCount = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0, 0, n, n);
        StringBuilder sb = new StringBuilder();
        sb.append(numberCount[0]).append("\n")
          .append(numberCount[1]).append("\n")
          .append(numberCount[2]);
        System.out.println(sb);
    }

    private static void divide(int x1, int y1, int x2, int y2) {
        // 크기가 1인 색종이일 때 || 하나의 숫자로만 채워지 색종이일 때
        int len = x2 - x1;
        if (len == 1 || isAllSameNumber(x1, y1, x2, y2)) {
            // 더 이상 분할할 필요 없으니, 해당 숫자 추가 후 return
            numberCount[arr[x1][y1] + 1]++;
            return;
        }
        for (int i = 0; i < len; i += len / 3) {
            for (int j = 0; j < len; j += len / 3) {
                divide(x1 + i, y1 + j, x1 + len / 3 + i, y1 + len / 3 + j);
            }
        }
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

