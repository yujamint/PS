package 그래프.연결요소의개수_11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m, cnt = 0;
    static boolean[] ch;
    static int[][] map;

    public static void DFS(int start) {
        if (ch[start]) return;

        ch[start] = true;

        for (int i = 1; i <= n; i++) {
            if (map[start][i] == 0 && ch[i]) continue;
            DFS(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ch = new boolean[n + 1];
        map = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (!ch[i]) {
                DFS(i);
                cnt++;
                for (int j = 1; j <= n; j++) {
                    System.out.print(ch[j] + " ");
                }
            }
        }

        System.out.println(cnt);
    }
}
