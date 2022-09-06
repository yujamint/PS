package 기초수학.최대공약수_1850;

import java.util.Scanner;

public class Main {
    public static long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;

            a = b;
            b = r;
        }
        return a;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();

        long gcd = gcd(Math.max(a, b), Math.min(a, b));

        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < gcd; i++) sb.append("1");

        System.out.println(sb.toString());

    }
}
