package section1;

import java.util.Scanner;
//강의에서는 str의 마지막에 " "을 넣어서 for문에서 i번째와 i+1번쨰를 비교하면서 cnt 처리함
public class Stringcompression {
    public String solution(String str) {
        String answer = "";
        char[] chs = str.toCharArray();
        char c = chs[0];
        int cnt=0;

        for(int i=0; i<chs.length; i++){
            if(chs[i] == c) {
                cnt++;
                if(i == chs.length-1)
                    answer += chs[i] + String.valueOf(cnt);
            }
            else{
                c = chs[i];
                if(cnt < 2) answer += chs[i-1];
                else answer += chs[i - 1] + String.valueOf(cnt);
                cnt = 1;
                if(i == chs.length-1)
                    answer += chs[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Stringcompression s = new Stringcompression();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(s.solution(str));
    }
}
