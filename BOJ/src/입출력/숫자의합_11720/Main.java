package 입출력.숫자의합_11720;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;

        int n = sc.nextInt();

        String str = sc.next();
        char[] chs = str.toCharArray();

        for (int i = 0; i < n; i++) {
            answer += chs[i] - 48;
        }

        System.out.println(answer);
    }
}
