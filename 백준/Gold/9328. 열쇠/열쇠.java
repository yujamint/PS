import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Door {
    Point point;
    char ch;

    public Door(int x, int y, char ch) {
        this.point = new Point(x, y);
        this.ch = ch;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static char[][] map;
    static Set<Character> keys;
    static List<Point> entryPoints;
    static Queue<Door> lockedDoors;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int documentCount, w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int T = 0; T < t; T++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            documentCount = 0;

            // 지도 입력 + 입구 찾기
            map = new char[h][w];
            visited = new boolean[h][w];
            entryPoints = new ArrayList<>();
            for (int i = 0; i < h; i++) {
                String input = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = input.charAt(j);
                }
            }

            // 처음에 가지고 있는 열쇠 저장
            keys = new HashSet<>();
            String keyInput = br.readLine();
            if (!keyInput.equals("0")) {
                for (int i = 0; i < keyInput.length(); i++) {
                    keys.add(keyInput.charAt(i));
                }
            }

            lockedDoors = new LinkedList<>();
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if ((i == 0 || i == h - 1 || j == 0 || j == w - 1)) {
                        if (map[i][j] == '*') {
                            continue;
                        }

                        if (Character.isUpperCase(map[i][j]) && !keys.contains(Character.toLowerCase(map[i][j]))) {
                            lockedDoors.offer(new Door(i, j, map[i][j]));
                            continue;
                        }
                        entryPoints.add(new Point(i, j));
                    }
                }
            }

            for (Point entry : entryPoints) {
                if (visited[entry.x][entry.y]) continue;
                BFS(entry);
            }

            int size;
            do {
                size = lockedDoors.size();
                for (int i = 0; i < size; i++) {
                    Door lockedDoor = lockedDoors.poll();
                    if (keys.contains(Character.toLowerCase(lockedDoor.ch))) {
                        BFS(lockedDoor.point);
                    } else {
                        lockedDoors.offer(lockedDoor);
                    }
                }
            } while (!lockedDoors.isEmpty() && size != lockedDoors.size());

            sb.append(documentCount).append('\n');
        }
        System.out.println(sb);
    }

    private static void BFS(Point entry) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(entry);
        visited[entry.x][entry.y] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            int x = cur.x, y = cur.y;

            // 문서 찾았을 때
            if (map[x][y] == '$') {
                documentCount++;
            }

            // 열쇠 찾았을 때
            if (Character.isLowerCase(map[x][y])) {
                keys.add(map[x][y]);
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == '*' || visited[nx][ny]) {
                    continue;
                }

                // 문인데 열쇠가 없다면
                if (Character.isUpperCase(map[nx][ny]) && !keys.contains(Character.toLowerCase(map[nx][ny]))) {

                    lockedDoors.offer(new Door(nx, ny, map[nx][ny]));
                    continue;
                }

                queue.offer(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }
}
