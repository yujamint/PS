import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, max = 1;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static char[][] map;
    static boolean[] visited = new boolean[26]; // 65 ~ 90

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        visited[map[0][0] - 65] = true;
        DFS(0, 0, 1);
        System.out.println(max);
    }

    private static void DFS(int x, int y, int cnt) {
        max = Math.max(max, cnt);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                char next = map[nx][ny];
                if (visited[next - 65]) continue;
                visited[next - 65] = true;
                DFS(nx, ny, cnt + 1);
                visited[next - 65] = false;
            }
        }
    }

}
