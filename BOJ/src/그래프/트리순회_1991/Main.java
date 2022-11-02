package 그래프.트리순회_1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] node;
    static StringBuilder sb;

    public static void DFS(int start, int method) {
        if (start < 0 || start >= n) return;

        int left = node[start][0];
        int right = node[start][1];

        if (method == -1) {
            sb.append((char) (start + 65));
            DFS(left, -1);
            DFS(right, -1);
        }
        else if (method == 0) {
            DFS(left, 0);
            sb.append((char) (start + 65));
            DFS(right, 0);
        }
        else if (method == 1) {
            DFS(left, 1);
            DFS(right, 1);
            sb.append((char) (start + 65));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        node = new int[n][2];

        String input;
        for (int i = 0; i < n; i++) {
            input = br.readLine();
            int idx = input.charAt(0) - 65;
            int left = input.charAt(2) - 65;
            int right = input.charAt(4) - 65;

            node[idx][0] = left;
            node[idx][1] = right;
        }

        sb = new StringBuilder();

        DFS(0, -1); // 전위순회
        sb.append("\n");
        DFS(0, 0); // 중위순회
        sb.append("\n");
        DFS(0, 1); // 후위순회

        System.out.println(sb);
    }
}
