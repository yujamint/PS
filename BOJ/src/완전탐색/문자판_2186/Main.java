package 완전탐색.문자판_2186;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static long cnt = 0;
    static char[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][][] dp;
    static String answer;

    public static int DFS(int x, int y, int L) {
        if (dp[x][y][L] != -1) return dp[x][y][L];
        if (L == answer.length()-1) return dp[x][y][L] = 1;

        dp[x][y][L] = 0;

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j] * i;
                int ny = y + dy[j] * i;

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (board[nx][ny] == answer.charAt(L+1)) dp[x][y][L] += DFS(nx, ny, L + 1);
            }
        }
        return dp[x][y][L];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        answer = br.readLine();
        dp = new int[n][m][answer.length()];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == answer.charAt(0)) cnt += DFS(i, j, 0);
            }
        }

        System.out.println(cnt);
    }
}
