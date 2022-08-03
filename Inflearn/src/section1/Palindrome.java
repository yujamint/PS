package section1;

import java.util.Locale;
import java.util.Scanner;
// 강의에서는 문자열 뒤집은 다음 입력받은 문자열과 동일한지 비교하는 방법 사용 // StringBuilder로 뒤집고, equalsIgnoreCase 함수 통해 대소문자 구분하지 않고 비교함
public class Palindrome {
    public String solution(String str){
        str = str.toUpperCase(Locale.ROOT);
        int n = str.length();
        for(int i=0; i<n/2; i++){
            if(str.charAt(i) != str.charAt(n-i-1))
                return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(p.solution(str));
    }
}
