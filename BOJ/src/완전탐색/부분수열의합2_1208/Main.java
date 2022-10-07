package 완전탐색.부분수열의합2_1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, s;
    static long answer = 0;
    static int idx;
    static int[] aSum, bSum;

    public static void DFS(int start, int sum, int len, int[] arr, int[] halfSum) {
        if (start == len) {
            halfSum[idx++] = sum;
        }

        else {
            DFS(start + 1, sum + arr[start], len, arr, halfSum);
            DFS(start + 1, sum, len, arr, halfSum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        int a = n/2;
        int b = n - a;

        int[] A = new int[a];
        int[] B = new int[b];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < a; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < b; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        aSum = new int[(int)Math.pow(2, a)];
        bSum = new int[(int) Math.pow(2, b)];

        DFS(0, 0, a, A, aSum);
        idx = 0;
        DFS(0, 0, b, B, bSum);

        Arrays.sort(aSum);
        Arrays.sort(bSum);

        int lt = 0, rt = bSum.length - 1;
        while (lt < aSum.length && rt >= 0) {
            int lcv = aSum[lt], rcv = bSum[rt];
            int sum = lcv + rcv;

            if (sum == s) {
                int aCnt = 0, bCnt = 0;

                while (lt < aSum.length && aSum[lt] == lcv) {
                    lt++;
                    aCnt++;
                }

                while (rt >= 0 && bSum[rt] == rcv) {
                    rt--;
                    bCnt++;
                }
                answer += (long)aCnt * bCnt;
            }

            else if (sum > s) rt--;
            else lt++;
        }

        System.out.println(s == 0 ? answer - 1 : answer);
    }
}