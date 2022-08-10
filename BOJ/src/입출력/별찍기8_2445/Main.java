package 입출력.별찍기8_2445;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("*".repeat(i));
            for (int j = i; j < 2 * n-i; j++) {
                System.out.print(" ");
            }
            System.out.println("*".repeat(i));
        }

        for (int i = n-1; i > 0; i--) {
            System.out.print("*".repeat(i));
            for (int j = i; j < 2 * n-i; j++) {
                System.out.print(" ");
            }
            System.out.println("*".repeat(i));
        }
    }
}
