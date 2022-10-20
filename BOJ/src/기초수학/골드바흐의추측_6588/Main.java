package 기초수학.골드바흐의추측_6588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] prime = new boolean[1_000_001];

        for (int i = 2; i <= 1_000_000; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i <= 1_000_000; i++) {
            for (int j = i * 2; j <= 1_000_000; j += i) {
                prime[j] = false;
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) return;

            boolean isPossible = false;
            for (int i=3; i <= n / 2; i++) {
                if (prime[i] && prime[n - i]) {
                    System.out.println(n + " = " + i + " + " + (n-i));
                    isPossible = true;
                    break;
                }
            }
            if (!isPossible) System.out.println("Goldbach's conjecture is wrong.");
        }
    }
}
