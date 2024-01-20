import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, answer;
    static int[][] status;
    static boolean[] team;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        team = new boolean[n];
        status = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                status[i][j] = Integer.parseInt(input.nextToken());
            }
        }
        answer = Integer.MAX_VALUE;
        DFS(0, 0);
        System.out.println(answer);
    }

    private static void DFS(int memberCount, int at) {
        if (memberCount == n / 2) {
//             A팀 합, B팀 합의 차 계산
            int aSum = 0, bSum = 0;
            for (int i = 0; i < n - 1; i++) {
                if (team[i]) {
                    for (int j = i + 1; j < n; j++) {
                        if (team[j]) {
                            aSum += status[i][j];
                            aSum += status[j][i];
                        }
                    }
                } else {
                    for (int j = i + 1; j < n; j++) {
                        if (!team[j]) {
                            bSum += status[i][j];
                            bSum += status[j][i];
                        }
                    }
                }
            }
            answer = Math.min(answer, Math.abs(bSum - aSum));
            return;
        }
        for (int i = at; i < n; i++) {
            team[i] = true;
            DFS(memberCount + 1, i + 1);
            team[i] = false;
        }
    }
}
