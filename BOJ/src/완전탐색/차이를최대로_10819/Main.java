package 완전탐색.차이를최대로_10819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, answer = Integer.MIN_VALUE;
    static int[] arr, selected, ch;
    public static void DFS(int L) {
        if (L == n) {
            answer = Math.max(getResult(), answer);
        }
        else {
            for (int i = 0; i < n; i++) {
                if (ch[i] != 1) {
                    ch[i] = 1;
                    selected[L] = arr[i];
                    DFS(L+1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        ch = new int[n];
        selected = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0);
        System.out.println(answer);

    }

    public static int getResult() {
        int sum = 0;
        for (int i = 0; i < n-1; i++) {
            sum += Math.abs(selected[i] - selected[i+1]);
        }
        return sum;
    }
}
