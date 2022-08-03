package section1;

import java.util.Scanner;

//길이가 n인 단어일 때, 2번째 index는 알파벳이고, n-1번째 index는 특수문자일 때는 어떻게 처리하는 거지? 명세가 자세하지 않은 거 같다..
//65~90 97~122
//Character.isAlphabetic() 함수로 알파벳 검사 가능!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class Wordflipoverr {
    public String solution(String str) {
        char[] chs = str.toCharArray();
        int lt = 0, rt = str.length() - 1;
        while (lt < rt) {
            if (((chs[lt] >= 65 & chs[lt] <= 90) | (chs[lt] >= 97 & chs[lt] <= 122)) & ((chs[rt] >= 65 & chs[rt] <= 90) | (chs[rt] >= 97 & chs[rt] <= 122))) {
                char tmp = chs[lt];
                chs[lt] = chs[rt];
                chs[rt] = tmp;
                lt++;
                rt--;
            }
            else if(!((chs[lt] >= 65 & chs[lt] <= 90) | (chs[lt] >= 97 & chs[lt] <= 122)))
                lt++;
            else if(!((chs[rt] >= 65 & chs[rt] <= 90) | (chs[rt] >= 97 & chs[rt] <= 122)))
                rt--;
        }
        return String.valueOf(chs);
    }

    public static void main(String[] args) {
        Wordflipoverr w = new Wordflipoverr();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(w.solution(str));
    }
}
