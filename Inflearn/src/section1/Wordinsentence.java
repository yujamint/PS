package section1;

import java.util.Scanner;

public class Wordinsentence {
    public String solution(String str){
        String answer = "";
        String[] array = str.split(" ");
        for(String s : array)
            if(answer.length() < s.length()) answer = s;
        return answer;
        //split 대신 indexOf() 함수를 통해 띄어쓰기 한 index 위치 찾고 그 index를 통해 SubString 함수로 자르면서 길이 비교하는 방법도 가능
    }

    public static void main(String[] args) {
        Wordinsentence w = new Wordinsentence();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(w.solution(str));
    }
}
