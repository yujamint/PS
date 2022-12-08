package 그리디.수묶기_1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        arr[n] = Integer.MAX_VALUE;
        Arrays.sort(arr);

        int idx;
        for (idx = 0; idx < n; idx++) {
            if (arr[idx] > 0) {
                break;
            }

            if (arr[idx + 1] <= 0) {
                answer += arr[idx] * arr[idx + 1];
                idx++;
            } else if (arr[idx + 1] > 0) {
                answer += arr[idx];
            }
        }

        for (int i = n - 1; i >= idx; i--) {
            if (arr[i] == 1 || i == idx) {
                answer += arr[i];
                continue;
            }

            if (arr[i - 1] > 1) {
                answer += arr[i] * arr[i - 1];
                i--;
            } else if (arr[i - 1] == 1) {
                answer += arr[i];
            }
        }

        System.out.println(answer);
    }
}
