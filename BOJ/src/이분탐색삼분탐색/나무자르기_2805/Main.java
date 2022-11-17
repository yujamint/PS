package 이분탐색삼분탐색.나무자르기_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int min = 0, max = Integer.MIN_VALUE;
    static int[] tree;

    public static int binarySearch() {
        int front = min, rear = max;
        while (front <= rear) {
            int midValue = (front + rear) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (tree[i] <= midValue) continue;
                sum += tree[i] - midValue;
            }

            if (sum == m) {
                return midValue;
            }
            if (sum > m) {
                front = midValue + 1;
                continue;
            }
            rear = midValue - 1;
        }
        return front - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        tree = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(st.nextToken());
            tree[i] = height;
            min = Math.min(min, height);
            max = Math.max(max, height);
        }

        System.out.println(binarySearch());
    }
}
