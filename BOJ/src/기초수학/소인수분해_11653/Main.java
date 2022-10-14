package 기초수학.소인수분해_11653;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                n /= i;
                System.out.println(i);
                i--;
            }
        }
    }
}
