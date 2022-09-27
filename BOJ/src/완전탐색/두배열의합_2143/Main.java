package 완전탐색.두배열의합_2143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) B[i] = Integer.parseInt(st.nextToken());

        int aSize = n * (n + 1) / 2;
        int bSize = m * (m + 1) / 2;

        long[] aSum = new long[aSize];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                aSum[idx++] = sum;
            }
        }

        long[] bSum = new long[bSize];
        idx = 0;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                bSum[idx++] = sum;
            }
        }

        Arrays.sort(aSum);
        Arrays.sort(bSum);

        long cnt = 0;
        int pa = 0, pb = bSize - 1;

        while (pa < aSize && pb >= 0) {
            long asv = aSum[pa], bsv = bSum[pb];
            long sum = asv + bsv;

            if (sum == T) {
                long aCnt = 0, bCnt = 0;

                while (pa < aSize && aSum[pa] == asv) {
                    pa++;
                    aCnt++;
                }

                while (pb >= 0 && bSum[pb] == bsv) {
                    pb--;
                    bCnt++;
                }

                cnt += aCnt * bCnt;
            }
            else if (sum > T) pb--;
            else pa++;
        }

        System.out.println(cnt);
    }
}
