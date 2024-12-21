import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    1. 빈 땅을 마킹하고, 해당 영역에 들어갔을 떄 이동할 수 있는 칸이 몇 개인지 확인
    2. 모든 칸을 이동하며, 상하좌우로 어떤 영역 밟을 수 있는지 확인(Set에 담기)
    3. Set에 담긴 영역들로 가면서 총 몇 칸 이동할 수 있는지 합산
     */

    private static final char EMPTY = '0';
    private static final char WALL = '1';

    static int n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[][] map;
    static int[][] mark;
    static boolean[][] visited;
    static Map<Integer, Integer> countByGround = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        mark = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        markGround();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == EMPTY) {
                    sb.append('0');
                    continue;
                }
                int count = breakWall(i, j) % 10;
                sb.append(count);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void markGround() {
        int idx = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == WALL || mark[i][j] != 0) { // 막힌 땅이거나, 이미 마킹된 영역이면 pass
                    continue;
                }
                BFS(idx++, i, j); // 마킹
            }
        }
    }

    private static void BFS(int groundIdx, int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            mark[x][y] = groundIdx;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == WALL) {
                    continue;
                }

                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                count++;
            }
        }
        countByGround.put(groundIdx, count);
    }

    private static int breakWall(int x, int y) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m || mark[nx][ny] == 0) {
                continue;
            }

            set.add(mark[nx][ny]);
        }

        int count = 1;
        for (Integer groundIdx : set) {
            count += countByGround.get(groundIdx);
        }
        return count;
    }
}
