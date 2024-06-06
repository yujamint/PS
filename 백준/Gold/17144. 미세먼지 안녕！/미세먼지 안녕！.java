import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, airCleanerTop = -1, airCleanerBottom;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static int[][] map;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1 && airCleanerTop == -1) airCleanerTop = i;
            }
        }
        airCleanerBottom = airCleanerTop + 1;

        for (int T = 0; T < t; T++) {
            // 미세먼지 확산
            BFS();
            // 공기청정기 작동
            cleanAir();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) answer += map[i][j];
            }
        }
        System.out.println(answer);
    }

    private static void BFS() {
        int[][] prevMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prevMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] >= 5) queue.offer(new int[]{i, j});
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            int dust = prevMap[x][y] / 5;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] != -1) {
                    map[nx][ny] += dust;
                    map[x][y] -= dust;
                }
            }
        }
    }

    private static void cleanAir() {
        // 상단
        int prev = map[airCleanerTop][1];
        map[airCleanerTop][1] = 0;
        for (int i = 2; i < m; i++) {
            int temp = map[airCleanerTop][i];
            map[airCleanerTop][i] = prev;
            prev = temp;
        }
        for (int i = airCleanerTop - 1; i >= 0; i--) {
            int temp = map[i][m - 1];
            map[i][m - 1] = prev;
            prev = temp;
        }
        for (int i = m - 2; i >= 0; i--) {
            int temp = map[0][i];
            map[0][i] = prev;
            prev = temp;
        }
        for (int i = 1; i < airCleanerTop; i++) {
            int temp = map[i][0];
            map[i][0] = prev;
            prev = temp;
        }
        // 하단
        prev = map[airCleanerBottom][1];
        map[airCleanerBottom][1] = 0;
        for (int i = 2; i < m; i++) {
            int temp = map[airCleanerBottom][i];
            map[airCleanerBottom][i] = prev;
            prev = temp;
        }
        for (int i = airCleanerBottom + 1; i < n; i++) {
            int temp = map[i][m - 1];
            map[i][m - 1] = prev;
            prev = temp;
        }
        for (int i = m - 2; i >= 0; i--) {
            int temp = map[n - 1][i];
            map[n - 1][i] = prev;
            prev = temp;
        }
        for (int i = n - 2; i > airCleanerBottom; i--) {
            int temp = map[i][0];
            map[i][0] = prev;
            prev = temp;
        }
    }

}
