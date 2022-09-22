package 완전탐색.알파벳_1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R,C, answer = Integer.MIN_VALUE;
    static char[][] board;
    static boolean[] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0}; // 3시, 6시, 9시, 12시

    public static void DFS(int x, int y, int cnt) {
        if (visited[(int)board[x][y] - 65]) {
            answer = Math.max(answer, cnt);
        }
        else {
            visited[(int)board[x][y] - 65] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || ny < 1 || nx > R || ny > C) continue;

                DFS(nx, ny, cnt+1);
            }
            visited[(int)board[x][y] - 65] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R + 1][C + 1];
        visited = new boolean[26]; // 알파벳

        for (int i = 1; i <= R; i++) {
            String input = br.readLine();
            for (int j = 1; j <= C; j++) {
                board[i][j] = input.charAt(j - 1);
            }
        }

        DFS(1,1,0);
        System.out.println(answer);
    }
}
