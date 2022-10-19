package 기초수학.팩토리얼0의개수_1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        BigInteger num = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            num = num.multiply(new BigInteger(Integer.toString(i)));
        }

        String result = num.toString();
        int cnt = 0;
        for (int i = result.length() - 1; i >= 0; i--) {
            if (result.charAt(i) == '0') cnt++;
            else break;
        }

        System.out.println(cnt);
    }
}
