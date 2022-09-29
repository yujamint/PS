package 완전탐색.피자판매_2632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int order = Integer.parseInt(br.readLine());
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Integer> a = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            a.offer(Integer.parseInt(br.readLine()));
        }

        Queue<Integer> b = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            b.offer(Integer.parseInt(br.readLine()));
        }

        int aSize = n * (n - 1) + 2;
        int bSize = m * (m - 1) + 2;

        int idx = 1;

        int[] aSum = new int[aSize];
        aSum[0] = 0;
        for (int i = 0; i < n; i++) {
            aSum[aSize-1] += a.peek();
            int sum = 0;
            for (int j = 0; j < n-1; j++) {
                int temp = a.poll();
                sum += temp;
                aSum[idx++] = sum;
                a.offer(temp);
            }
        }

        idx = 1;

        int[] bSum = new int[bSize];
        bSum[0] = 0;
        for (int i = 0; i < m; i++) {
            bSum[bSize-1] += b.peek();
            int sum = 0;
            for (int j = 0; j < m-1; j++) {
                int temp = b.poll();
                sum += temp;
                bSum[idx++] = sum;
                b.offer(temp);
            }
        }

        Arrays.sort(aSum);
        Arrays.sort(bSum);

        int left = 0, right = bSize - 1;

        while (left < aSize && right >= 0) {
            int asv = aSum[left], bsv = bSum[right];
            int sum = asv + bsv;

            if (sum == order) {
                int aCnt = 0;
                int bCnt = 0;

                while (left < aSize && aSum[left] == asv) {
                    left++;
                    aCnt++;
                }

                while (right >= 0 && bSum[right] == bsv) {
                    right--;
                    bCnt++;
                }

                answer += aCnt * bCnt;
            }

            else if (sum > order) right--;
            else left++;
        }

        System.out.println(answer);
    }
}
