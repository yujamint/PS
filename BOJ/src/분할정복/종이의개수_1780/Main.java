package 분할정복.종이의개수_1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] answer;
    static int[][] paper;

    public static void DFS(int rowS, int rowE, int colS, int colE) {
        if (rowE - rowS == 1) { // 한 칸 짜리라면 바로 카운트
            int index = paper[rowS][colS] + 1;
            answer[index] += 1;
            return;
        }

        int val = paper[rowS][colS]; // 다른 값이 들어있는지 알기 위해 대조할 값

        for (int row = rowS; row < rowE; row++) {
            for (int col = colS; col < colE; col++) {
                if (paper[row][col] != val) { // 다른 값이 들어있다면,
                    int len = (rowE - rowS) / 3;
                    for (int i = 0; i < 3; i++) { // 9개로 나눈다.
                        for (int j = 0; j < 3; j++) {
                            DFS(rowS + len * i, rowS + len * (i + 1), colS + len * j, colS + len * (j + 1));
                        }
                    }
                    return;
                }
            }
        }

        answer[val + 1] += 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        answer = new int[3]; // -1, 0, 1

        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int col = 0; col < n; col++) {
                paper[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, n, 0, n);

        for (int i = 0; i < 3; i++) {
            System.out.println(answer[i]);
        }
    }
}
