package 그래프.텀프로젝트_9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, teamCnt;
    static boolean[] ch;
    static int[] teamSelection;
    static List<Integer> list = new ArrayList<>();

    public static void DFS(int x, int team, int memberCnt) {
        if (list.contains(team) || ch[team]) {
            return;
        }

        list.add(team);

        if (x == team) {
            teamCnt += memberCnt;
            for (int teamMember : list) {
                ch[teamMember] = true;
            }
            return;
        }

        DFS(x, teamSelection[team], memberCnt + 1);
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
            ch = new boolean[n + 1];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= n; i++) {
                teamSelection[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!ch[i]) {
                    list = new ArrayList<>();
                    DFS(i, teamSelection[i], 1);
                    ch[i] = true;
                }
            }
            sb.append(n-teamCnt).append("\n");
        }
        System.out.print(sb);
    }
}
