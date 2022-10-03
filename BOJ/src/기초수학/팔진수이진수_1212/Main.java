package 기초수학.팔진수이진수_1212;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        StringBuilder sb = new StringBuilder("");
        sb.append(Integer.toBinaryString(str.charAt(0) - '0'));

        for (int i = 1; i < str.length(); i++) {
            int c = str.charAt(i) - '0';

            if (c >= 4) sb.append(Integer.toBinaryString(c));

            else if (c < 4 && c >= 2) {
                sb.append("0").append(Integer.toBinaryString(c));
            } else {
                sb.append("00").append(Integer.toBinaryString(c));
            }
        }

        System.out.println(sb.toString());
    }
}
