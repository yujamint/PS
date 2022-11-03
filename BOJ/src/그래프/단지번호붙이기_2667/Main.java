package 그래프.단지번호붙이기_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int n, homeCount = 0, blockCount = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] ch;
    static int[][] map;
    static List<Integer> homeCounts = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        ch = new boolean[n][n];
        map = new int[n][n];

        for (int x = 0; x < n; x++) {
            String input = br.readLine();
            for (int y = 0; y < n; y++) {
                map[x][y] = input.charAt(y) - '0';
            }
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (map[x][y] == 0 || ch[x][y]) {
                    continue;
                }

                DFS(x, y);
                homeCounts.add(homeCount);
                homeCount = 0;
                blockCount++;
            }
        }

        sb.append(blockCount).append("\n");

        Collections.sort(homeCounts);
        for (int homeCnt : homeCounts) {
            sb.append(homeCnt).append("\n");
        }

        System.out.print(sb);
    }

    private static void DFS(int x, int y) {
        homeCount++;
        ch[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= n || ny >= n || nx < 0 || ny < 0) continue;

            if (ch[nx][ny] || map[nx][ny] == 0) continue;

            DFS(nx, ny);
        }
    }
}
