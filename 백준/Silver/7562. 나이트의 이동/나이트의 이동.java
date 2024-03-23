import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    static class Pair {
        int x;
        int y;
        int count;

        public Pair(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Queue<Pair> queue;
        boolean[][] visited;
        for (int t = 0; t < T; t++) {
            int l = Integer.parseInt(br.readLine());
            visited = new boolean[l][l];
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int toX = Integer.parseInt(st.nextToken());
            int toY = Integer.parseInt(st.nextToken());

            queue = new LinkedList<>();
            queue.offer(new Pair(x, y, 0));
            while (!queue.isEmpty()) {
                Pair cur = queue.poll();
                if (cur.x == toX && cur.y == toY) {
                    sb.append(cur.count).append("\n");
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx >= l || ny >= l || nx < 0 || ny < 0) continue;
                    if (visited[nx][ny]) continue;

                    visited[nx][ny] = true;
                    queue.offer(new Pair(nx, ny, cur.count + 1));
                }
            }
        }
        System.out.println(sb);
    }

}
