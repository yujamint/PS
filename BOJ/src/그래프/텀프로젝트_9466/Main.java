package 그래프.텀프로젝트_9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, teamCnt;
    static boolean[] visited, finished;
    static int[] teamSelection;

    public static void DFS(int x) {
        if (finished[x]) return;
        if (visited[x]) {
            finished[x] = true;
            teamCnt++;
        }
        visited[x] = true;
        DFS(teamSelection[x]);
        visited[x] = false;
        finished[x] = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test = 0; test < T; test++) {
            n = Integer.parseInt(br.readLine());

            teamCnt = 0;
            teamSelection = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= n; i++) {
                teamSelection[i] = Integer.parseInt(st.nextToken());
                if (i == teamSelection[i]) {
                    teamCnt++;
                    finished[i] = true;
                }
            }

            for (int i = 1; i <= n; i++) {
                DFS(i);
            }
            sb.append(n - teamCnt).append("\n");
        }
        System.out.print(sb);
    }
}
