package section1;

import java.util.Locale;
import java.util.Scanner;
//replaceAll과 정규식!
public class Palindromee {
    public String solution(String str){
        String Pattern = "[^a-zA-Z]";
        str = str.replaceAll(Pattern,"");
        str = str.toUpperCase(Locale.ROOT);
        int n = str.length();
        for(int i=0; i<n/2; i++){
            if(str.charAt(i) != str.charAt(n-i-1))
                return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        Palindromee p = new Palindromee();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(p.solution(str));
    }
}
