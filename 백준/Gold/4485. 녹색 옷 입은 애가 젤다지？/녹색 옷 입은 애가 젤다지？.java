import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int x;
    int y;
    int weight;

    public Node(int x, int y, int weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class Main {

    private static final int INF = 1234567890;

    static int n;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            visited = new boolean[n * n];
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = dijkstra();
            sb.append("Problem ").append(t++).append(": ").append(result).append('\n');
        }
        System.out.println(sb);
    }

    private static int dijkstra() {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0 || j != 0) dist[i][j] = INF;
            }
        }
        dist[0][0] = map[0][0];

        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(0, 0, map[0][0]));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x, y = cur.y;

            if (x == n - 1 && y == n - 1) {
                return dist[x][y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= n || ny >= n || nx < 0 || ny < 0) continue;

                if (dist[nx][ny] > dist[x][y] + map[nx][ny]) {
                    dist[nx][ny] = dist[x][y] + map[nx][ny];
                    queue.offer(new Node(nx, ny, dist[nx][ny]));
                }
            }
        }
        return -1;
    }
}

