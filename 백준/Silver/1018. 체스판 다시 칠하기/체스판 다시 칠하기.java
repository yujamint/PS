import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                int c = count(i, j);
                answer = Math.min(answer, c);
            }
        }

        System.out.println(answer);
    }

    private static int count(int startX, int startY) {
        int count1 = 0;
        int count2 = 0;
        char color1 = 'W';
        char color2 = 'B';
        for (int i = startX; i < startX + 8; i++) {
            color1 = color1 == 'B' ? 'W' : 'B';
            color2 = color2 == 'B' ? 'W' : 'B';
            for (int j = startY; j < startY + 8; j++) {
                if (board[i][j] != color1) {
                    count1++;
                }
                if (board[i][j] != color2) {
                    count2++;
                }
                color1 = color1 == 'B' ? 'W' : 'B';
                color2 = color2 == 'B' ? 'W' : 'B';
            }
        }
        return Math.min(count1, count2);
    }
}
