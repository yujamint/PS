package section1;

import java.util.Scanner;
//ASCII TABLE48~57 -> 숫자 0~9 이용해서 할 수도 있다.
public class Numberextraction {
    public int solution(String str){
        String answer = "";
        char[] chs = str.toCharArray();
        for(char c : chs)
            if(Character.isDigit(c))
                answer+=c;
        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        Numberextraction n = new Numberextraction();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(n.solution(str));
    }
}
