package section1;

import java.util.Locale;
import java.util.Scanner;

public class Charsearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String input2 = sc.nextLine();
        input1 = input1.toUpperCase(Locale.ROOT);
        input2 = input2.toUpperCase(Locale.ROOT);
        char[] chs = input1.toCharArray();
        int cnt = 0;
        for(int i=0; i<chs.length; i++){
            if(Character.toString(chs[i]).equals(input2))
                cnt++;
        }
        System.out.print(cnt);
    }
}
