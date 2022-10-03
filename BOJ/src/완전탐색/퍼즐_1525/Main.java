package 완전탐색.퍼즐_1525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static String answer = "123456780";
    static Map<String, Integer> map = new HashMap<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int BFS(String init) {
        Queue<String> q = new LinkedList<>();
        q.offer(init);

        int L=0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                String cur = q.poll();
                if (cur.equals(answer)) return L;

                int blank = cur.indexOf('0');
                int x = blank / 3;
                int y = blank % 3;

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx < 0 || ny < 0 || nx >= 3 || ny >= 3) continue;

                    String next = swap(cur, blank, nx * 3 + ny);
                    if (!map.containsKey(next)) {
                        map.put(next, 0);
                        q.offer(next);
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static String swap(String str, int a, int b) {
        StringBuilder sb = new StringBuilder(str);

        char temp = str.charAt(b);
        sb.setCharAt(b, str.charAt(a));
        sb.setCharAt(a, temp);

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String init = "";

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                init += st.nextToken();
            }
        }

        map.put(init, 0);
        System.out.println(BFS(init));
    }
}
