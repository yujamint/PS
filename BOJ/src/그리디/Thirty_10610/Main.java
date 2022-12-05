package 그리디.Thirty_10610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] digits = br.readLine().toCharArray();

        Arrays.sort(digits);

        String reverse = new StringBuilder(new String(digits)).reverse().toString();

        BigInteger n = new BigInteger(reverse);

        if (n.remainder(BigInteger.valueOf(30)).compareTo(BigInteger.ZERO) != 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(n);
    }
}
