import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static int[][] map, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        answer = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer[i][j] = -1;
            }
        }
        int destX = 0, destY = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    destX = i;
                    destY = j;
                }
                if (map[i][j] == 0) answer[i][j] = 0;
            }
        }
        BFS(destX, destY);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(answer[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        answer[x][y] = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || answer[nx][ny] != -1) {
                    continue;
                }
                answer[nx][ny] = answer[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }
    }

}
