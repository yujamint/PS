package 입출력.별찍기17_10992;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n-1; i++) {
            for (int j = 1; j < n - i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            if (i >= 1) {
                for (int k = 0; k < 2 * i - 1; k++) {
                    System.out.print(" ");
                }
                System.out.println("*");
            }
            else System.out.println("");
        }
        System.out.println("*".repeat(2 * n - 1));
    }
}
