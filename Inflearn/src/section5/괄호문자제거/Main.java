package section5.괄호문자제거;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public String solution(String s){
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char x : s.toCharArray()){
            if(x == ')') {
                while(stack.pop() != '(');
            }
            else stack.push(x);
        }
        for(char x : stack)
            answer+=x;
        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(m.solution(str));
    }
}
