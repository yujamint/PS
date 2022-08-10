package 입출력.열개씩끊어출력하기_11721;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int n = str.length() / 10;

        String[] strs = new String[n + 1];

        int i = 0;
        for (i = 0; i < n; i++) {
            strs[i] = str.substring(i*10, (i+1) * 10);
        }

        strs[n] = str.substring(i * 10, str.length());

        for (String x : strs) System.out.println(x);
    }
}
