package 기초수학.소수찾기_1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static boolean isPrime(int num) {
        boolean[] prime = new boolean[num + 1];

        for (int i = 2; i <= num; i++) prime[i] = true;

        for (int i = 2; i * i <= num; i++) {
            for (int j = i * i; j <= num; j += i) {
                prime[j] = false;
            }
        }

        return prime[num];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (isPrime(num)) cnt++;
        }

        System.out.println(cnt);
    }
}
