package section1;
//String의 replace 함수 이어붙여서 쓸 수 있다. str.replace('','').replace('',''); 이런 식으로
import java.util.Scanner;
//1. 문자열 replaceAll 통해 이진수 형태로 만들기
//2. int to char ASCII
//3. 7개씩 자르기 -> Substring , split?
public class Password {
    public String solution(int cnt,String str){
        String answer = "";
        char[] msg = new char[cnt];

        str = str.replaceAll("#", "1");
        str = str.replaceAll("[*]", "0");

        for(int i=0; i<cnt; i++){
            String tmp = str.substring(0,7);
            str = str.substring(7);
            msg[i] = (char)Integer.parseInt(tmp,2);
        }

        for(int i=0; i<cnt; i++)
            answer += msg[i];

        return answer;
    }

    public static void main(String[] args) {
        Password p = new Password();
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        String str = sc.next();
        System.out.println(p.solution(cnt, str));
    }
}
