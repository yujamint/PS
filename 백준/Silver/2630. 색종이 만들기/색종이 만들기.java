import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] colorCount = new int[2];
    // white 0, blue 1
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divideConfetti(0, 0, n, n);
        StringBuilder sb = new StringBuilder();
        sb.append(colorCount[0]).append("\n").append(colorCount[1]);
        System.out.println(sb);
    }

    private static void divideConfetti(int x1, int y1, int x2, int y2) {
        // 크기가 1인 정사각형일 때 || 하나의 색으로만 칠해진 정사각형일 때
        int len = x2 - x1;
        if (len == 1 || isAllSameColor(x1, y1, x2, y2)) {
            // 더 이상 분할할 필요 없으니, 해당 색 count 늘리고 return
            int color = arr[x1][y1];
            colorCount[color]++;
            return;
        }
        divideConfetti(x1, y1, x1 + len / 2, y1 + len / 2); // (0,0) (4,4)
        divideConfetti(x1, y1 + len / 2, x1 + len / 2, y2); // (0,4) (4,8)
        divideConfetti(x1 + len / 2, y1, x2, y1 + len / 2); // (4,0) (8,4)
        divideConfetti(x1 + len / 2, y1 + len / 2, x2, y2); // (4,4) (8,8)
    }

    private static boolean isAllSameColor(int x1, int y1, int x2, int y2) {
        int color = arr[x1][y1];
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (arr[i][j] != color) return false;
            }
        }
        return true;
    }
}
