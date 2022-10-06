package 완전탐색.합이0인네정수_7453;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long cnt = 0;
    static int[] A, B, C, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        A = new int[n];
        B = new int[n];
        C = new int[n];
        D = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int size = n*n;
        int[] AB = new int[size];
        int[] CD = new int[size];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[idx] = A[i] + B[j];
                CD[idx++] = C[i] + D[j];
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);


        int lt = 0, rt = size - 1;
        while (lt < size && rt >= 0) {
            int lcv = AB[lt], rcv = CD[rt];
            int sum = lcv + rcv;

            int abCnt = 0, cdCnt = 0;
            if (sum == 0) {
                while (lt < size && AB[lt] == lcv) {
                    abCnt++;
                    lt++;
                }

                while (rt >= 0 && CD[rt] == rcv) {
                    cdCnt++;
                    rt--;
                }

                cnt += (long)abCnt * cdCnt;
            }
            else if (sum > 0) rt--;
            else if (sum < 0) lt++;
        }


        System.out.println(cnt);
    }
}
