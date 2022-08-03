package section5.쇠막대기;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') stack.push('(');
            else {
                stack.pop();
                if(s.charAt(i-1) == '(') answer+=stack.size();
                else answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(m.solution(s));
    }
}
