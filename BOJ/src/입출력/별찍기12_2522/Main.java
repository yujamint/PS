package 입출력.별찍기12_2522;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
            System.out.println("*".repeat(i));
        }

        for (int i = n-1; i > 0; i--) {
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
            System.out.println("*".repeat(i));
        }
    }
}
