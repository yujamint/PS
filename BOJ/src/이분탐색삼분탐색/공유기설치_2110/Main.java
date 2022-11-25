package 이분탐색삼분탐색.공유기설치_2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int lo = 1;
        int hi = arr[n - 1];

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            int position = 0; // 공유기 설치 위치(처음부터 시작)
            int cnt = 1; // 설치 가능한 공유기 수
            for (int i = 1; i < n; i++) {
                if (arr[i] - arr[position] >= mid) {
                    position = i;
                    cnt++;
                }
            }

            if (cnt < c) {
                hi = mid - 1;
                continue;
            }
            lo = mid + 1;
        }

        System.out.println(lo - 1);
    }
}
