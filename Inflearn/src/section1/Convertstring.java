package section1;

import java.util.Scanner;

public class Convertstring {
    public String solution(String s) {
        String answer;
        char[] chs = s.toCharArray();
        for(int i=0; i<chs.length; i++){
            if(chs[i] >= 65 & chs[i] <=90) //나는 아스키코드로 대/소문자 판별하였는데, Character 클래스에 isLowerCase()라는 소문자 검사 함수가 있다.
                chs[i] = Character.toLowerCase(chs[i]); // toLowerCase 대신 (char)(chs[i]+32)도 가능
            else
                chs[i] = Character.toUpperCase(chs[i]); // toUpperCase 대신 (char)(chs[i]-32)도 가능
        }
        answer = String.valueOf(chs);
        return answer;
    }

    public static void main(String[] args) {
        Convertstring c = new Convertstring();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(c.solution(input));
    }
}
