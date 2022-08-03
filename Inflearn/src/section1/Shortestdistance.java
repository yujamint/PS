package section1;

import java.util.Scanner;
//문제 접근 방식부터 달랐던 거 같다.
//강의에서는 변수 p를 설정해놓고 찾으려고 하는 문자 t를 만날 때마다 0으로 만들어주면서 왼쪽부터 for문 돌고, 최소 거리를 위해 오른쪽부터 for문을 한 번 더 돌았음
public class Shortestdistance {
    public String solution(String str, char c){
        String answer = "";

        int index = str.indexOf(c);
        for(int i=0; i<=index; i++){ // 첫 문자가 나올 떄 까지
            answer += index-i + " ";
        }

        while(str.indexOf(c) != -1) { // 문자 사이에서 최소 거리 계산
            str = str.substring(index + 1);
            index = str.indexOf(c);
            for (int i = 0; i <= index; i++) {
                if (i + 1 > index - i)
                    answer += index - i + " ";
                else
                    answer += i + 1 + " ";
            }
        }
        for(int i=0; i<str.length(); i++) // 문자가 더 이상 안 나올 때의 거리 계산
            answer += i+1 + " ";

        return answer;
    }

    public static void main(String[] args) {
        Shortestdistance s = new Shortestdistance();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        System.out.println(s.solution(str, c));
    }
}
