package 기초수학.최소공배수_1934;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int min = 0;
            for (int j = 1; j <= a; j++) {
                if (a % j == 0 && b % j == 0) min = j;
            }

            System.out.println(a * b / min);
        }
    }
}
