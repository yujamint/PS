package 기초수학.소수구하기_1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[B + 1];

        for (int i = 2; i <= B; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i <= B; i++) {
            for (int j = 2 * i; j <= B; j += i) {
                prime[j] = false;
            }
        }

        for (int i = A; i <= B; i++) {
            if (prime[i]) System.out.println(i);
        }
    }
}
