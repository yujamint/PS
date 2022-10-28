package 그래프.DFS와BFS_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n,m,v;
    static boolean[] ch;
    static int[][] arr;

    public static void DFS(int start) {
        ch[start] = true;
        sb.append(start).append(" ");

        int[] edges = arr[start];
        for (int i = 1; i <= n; i++) {

            if (edges[i] == 0 || ch[i]) continue;

            ch[i] = true;
            DFS(i);
        }
    }

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        ch[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");
            int[] edges = arr[cur];
            for (int i = 1; i <= n; i++) {
                if (ch[i] || edges[i] == 0) continue;
                queue.offer(i);
                ch[i] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        ch = new boolean[n+1];
        arr = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[start][end] = arr[end][start] = 1;
        }

        DFS(v);

        sb.append("\n");
        ch = new boolean[n + 1];

        BFS(v);

        System.out.println(sb);
    }
}
