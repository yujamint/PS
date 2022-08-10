package 입출력.Add_AB_6_10953;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String str = sc.next();

            String[] strs = str.split(",");

            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);

            System.out.println(a + b);
        }

    }
}
