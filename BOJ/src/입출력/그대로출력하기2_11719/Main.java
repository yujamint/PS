package 입출력.그대로출력하기2_11719;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            System.out.println(str);
        }
    }
}
