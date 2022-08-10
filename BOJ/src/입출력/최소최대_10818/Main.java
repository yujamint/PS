package 입출력.최소최대_10818;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            max = Math.max(max, a);
            min = Math.min(min, a);
        }

        System.out.println(min + " " + max);

    }
}
