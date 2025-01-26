import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Shark {
    int speed;
    int dir;
    int size;

    public Shark(int speed, int dir, int size) {
        this.speed = speed;
        this.dir = dir;
        this.size = size;
    }
}

public class Main {

    static int r, c;
    static Shark[][] map;
    static Queue<int[]> points = new LinkedList<>();
    static int[] dx = {-99, -1, 1, 0, 0};
    static int[] dy = {-99, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new Shark[r + 1][c + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            s = convertSpeed(s, d);
            map[x][y] = new Shark(s, d, z);
            points.offer(new int[]{x, y});
        }

        int sum = 0;
        for (int fisher = 1; fisher <= c; fisher++) {
            Shark[][] nextMap = new Shark[r + 1][c + 1];
            for (int row = 1; row <= r; row++) {
                if (map[row][fisher] != null) {
                    Shark shark = map[row][fisher];
                    sum += shark.size;
                    map[row][fisher] = null;
                    break;
                }
            }

            int pointSize = points.size();
            for (int i = 0; i < pointSize; i++) {
                int[] point = points.poll();
                int x = point[0], y = point[1];
                if (map[x][y] == null) continue; // 잡아먹힌 상어의 포인트는 제거

                Shark shark = map[x][y];
                int dir = shark.dir;
                int curX = x, curY = y;
                for (int j = 0; j < shark.speed; j++) {
                    int nx = curX + dx[dir];
                    int ny = curY + dy[dir];
                    if (nx > r || nx < 1 || ny > c || ny < 1) {
                        dir = reverseDirection(dir);
                        nx = curX + dx[dir];
                        ny = curY + dy[dir];
                    }
                    curX = nx;
                    curY = ny;
                }

                shark.dir = dir;
                if (nextMap[curX][curY] == null) {
                    nextMap[curX][curY] = shark;
                    points.offer(new int[]{curX, curY});
                }
                else {
                    Shark existingShark = nextMap[curX][curY];
                    if (existingShark.size < shark.size) {
                        nextMap[curX][curY] = shark;
                    }
                }

                map[x][y] = null;
            }
            map = nextMap;
        }

        System.out.println(sum);
    }

    private static int convertSpeed(int speed, int dir) {
        if (dir == 1 || dir == 2) {
            return speed % ((r - 1) * 2);
        } else {
            return speed % ((c - 1) * 2);
        }
    }

    private static int reverseDirection(int dir) {
        if (dir == 1) {
            return 2;
        } else if (dir == 2) {
            return 1;
        } else if (dir == 3) {
            return 4;
        } else {
            return 3;
        }
    }
}
