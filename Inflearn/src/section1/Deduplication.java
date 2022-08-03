package section1;

import java.util.Scanner;
//문자열 포함 여부 검사
//1.indexOf -> 처음 나오는 위치 반환 --> 현재 위치가 처음 나오는 위치가 아니라면 추가 X
//2.contains -> 포함 여부 반환(Boolean)
//3.matches -> 정규식 검사
public class Deduplication {
    public String solution(String str){
        String answer = "";
        char[] chs = str.toCharArray();
        for(char c : chs)
            if(!answer.contains(String.valueOf(c))) answer += c;
        return answer;
    }

    public static void main(String[] args) {
        Deduplication d = new Deduplication();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(d.solution(str));
    }
}
