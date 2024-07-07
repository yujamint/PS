import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, idx = 1, answer = 0;
    static int[][] visited;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {
                    DFS(i, j);
                }
            }
        }
        System.out.println(answer);
    }

    private static void DFS(int x, int y) {
        visited[x][y] = idx;
        int[] next = next(x, y);
        int nx = next[0], ny = next[1];
        if (visited[nx][ny] == 0) {
            DFS(nx, ny);
        } else {
            if (visited[nx][ny] == idx) {
                answer++;
            }
            idx++;
        }
    }

    private static int[] next(int x, int y) {
        switch (map[x][y]) {
            case 'U':
                return new int[]{x - 1, y};
            case 'D':
                return new int[]{x + 1, y};
            case 'L':
                return new int[]{x, y - 1};
            case 'R':
                return new int[]{x, y + 1};
        }
        return new int[0];
    }


}
