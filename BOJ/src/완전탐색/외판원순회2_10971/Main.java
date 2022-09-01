package 완전탐색.외판원순회2_10971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, answer = Integer.MAX_VALUE;
    static int[] ch,selected;
    static int[][] W;

    public static void DFS(int count, int now, int result) {
        if (count == n-1) {
            if (W[now][0] != 0) {
                result += W[now][0];
                answer = Math.min(answer, result);
            }
        } else {
            for (int i = 1; i < n; i++) {
                if (W[now][i] != 0 && ch[i] == 0) {
                    ch[i] = 1;
                    DFS(count+1, i, result + W[now][i]);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        W = new int[n][n];
        ch = new int[n];
        selected = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0,0,0);

        System.out.println(answer);

    }
}
