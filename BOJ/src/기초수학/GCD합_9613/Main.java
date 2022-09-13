package 기초수학.GCD합_9613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int GCD(int a, int b) {
        while (b != 0) {
            int r = a % b;

            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            for (int j = 0; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[j] > arr[k]) sum += GCD(arr[j], arr[k]);
                    else sum += GCD(arr[k], arr[j]);
                }
            }

            System.out.println(sum);

        }
    }
}
