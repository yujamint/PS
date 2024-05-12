import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        int sx = 0, sy = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'I') {
                    sx = i;
                    sy = j;
                }
            }
        }
        int res = BFS(sx, sy);
        System.out.println(res == 0 ? "TT" : res);
    }

    private static int BFS(int sx, int sy) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            if (map[x][y] == 'P') count++;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny] || map[nx][ny] == 'X') continue;
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        return count;
    }

}
