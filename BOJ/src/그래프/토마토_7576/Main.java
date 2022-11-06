package 그래프.토마토_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomatao {
    int x;
    int y;

    public Tomatao(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int m, n, cnt = -1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static Queue<Tomatao> queue = new LinkedList<>();

    public static void BFS() {
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Tomatao cur = queue.poll();

                int cx = cur.x;
                int cy = cur.y;

                for (int j = 0; j < 4; j++) {
                    int nx = cx + dx[j];
                    int ny = cy + dy[j];

                    if (nx >= n || ny >= m || nx < 0 || ny < 0) {
                        continue;
                    }

                    if (arr[nx][ny] != 0) {
                        continue;
                    }

                    arr[nx][ny] = 1;
                    queue.offer(new Tomatao(nx, ny));
                }
            }
            cnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 1) queue.offer(new Tomatao(i, j));
            }
        }

        BFS();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }
            }
        }

        System.out.println(cnt);
    }


}
