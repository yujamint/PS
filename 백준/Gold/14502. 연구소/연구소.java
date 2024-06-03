import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, max = 0, totalArea, wallArea, virusArea;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static List<Node> empty = new ArrayList<>();
    static boolean[][] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        wallArea = 0;
        totalArea = n * m;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) empty.add(new Node(i, j));
                if (map[i][j] == 1) wallArea++;
            }
        }

        wall(0, 0);
        System.out.println(max);
    }

    private static void wall(int startIdx, int count) {
        if (count == 3) {
            max = Math.max(max, totalArea - (wallArea + 3 + countVirusArea()));
            return;
        }
        for (int i = startIdx; i < empty.size(); i++) {
            Node cur = empty.get(i);
            map[cur.x][cur.y] = 1;
            wall(i + 1, count + 1);
            map[cur.x][cur.y] = 0;
        }
    }

    private static int countVirusArea() {
        virusArea = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2 && !visited[i][j]) {
                    visited[i][j] = true;
                    DFS(i, j);
                }
            }
        }
        return virusArea;
    }

    private static void DFS(int x, int y) {
        virusArea++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;
            if (map[nx][ny] != 1) {
                visited[nx][ny] = true;
                DFS(nx, ny);
            }
        }
    }

}
