package 분할정복.쿼드트리_1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] arr;
    static StringBuilder sb;

    public static void DFS(int xStart, int xEnd, int yStart, int yEnd) {

        if (hasDifferentDigit(xStart, xEnd, yStart, yEnd)) {
            sb.append('(');

            int newLen = (xEnd - xStart) / 2;

            DFS(xStart, xStart + newLen, yStart, yStart + newLen); // 왼쪽 위
            DFS(xStart, xStart + newLen, yStart + newLen, yEnd); // 오른쪽 위
            DFS(xStart + newLen, xEnd, yStart, yStart + newLen); // 왼쪽 아래
            DFS(xStart + newLen, xEnd, yStart + newLen, yEnd); // 오른쪽 아래

            sb.append(')');
        }
        else {
            sb.append(arr[xStart][yStart]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        DFS(0, n, 0, n);

        System.out.println(sb);
    }

    public static boolean hasDifferentDigit(int xStart, int xEnd, int yStart, int yEnd) {
        int data = arr[xStart][yStart];

        for (int i = xStart; i < xEnd; i++) {
            for (int j = yStart; j < yEnd; j++) {
                if (arr[i][j] != data) {
                    return true;
                }
            }
        }
        return false;
    }
}
