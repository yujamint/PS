import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            if (this.time == o.time) {
                if (this.x == o.x) {
                    return this.y - o.y;
                }
                return this.x - o.x;
            }
            return this.time - o.time;
        }
    }

    static int n;
    static int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        StringTokenizer st;
        int startX = 0, startY = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    startX = i;
                    startY = j;
                    map[i][j] = 0;
                }
            }
        }
        System.out.println(BFS(startX, startY));
    }

    private static int BFS(int sx, int sy) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(sx, sy, 0));
        visited[sx][sy] = true;
        int shark = 2, experience = 0;
        int maxTime = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x, y = cur.y, time = cur.time;
            if (map[x][y] != 0 && map[x][y] < shark) {
                experience++;
                if (experience == shark) {
                    shark++;
                    experience = 0;
                }
                queue.clear();
                visited = new boolean[n][n];
                visited[x][y] = true;
                map[x][y] = 0;
                maxTime = Math.max(maxTime, time);
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && map[nx][ny] <= shark) {
                    queue.offer(new Node(nx, ny, time + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        return maxTime;
    }

}
