package 완전탐색.스타트링크_5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F, S, G, U, D;
    static int[] visited;

    public static void BFS(int S) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        visited[S] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == G) {
                System.out.println(visited[cur] -1);
                return;
            }

            int up = cur + U;
            int down = cur - D;

            if (up <= F && visited[up] == 0) {
                queue.offer(up);
                visited[up] = visited[cur] + 1;
            }
            if (down >= 1 && visited[down] == 0 ) {
                queue.offer(down);
                visited[down] = visited[cur] + 1;
            }
        }
        System.out.println("use the stairs");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        F = Integer.parseInt(st.nextToken()); // 건물 층 수
        S = Integer.parseInt(st.nextToken()); // 강호 위치
        G = Integer.parseInt(st.nextToken()); // 스타트링크 위치
        U = Integer.parseInt(st.nextToken()); // 위로 몇 칸
        D = Integer.parseInt(st.nextToken()); // 아래로 몇 칸

        visited = new int[F + 1];

        BFS(S);
    }
}
