package section5.올바른괄호;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public String solution(String s) {
        String answer = "NO";
        Stack<Character> stack = new Stack<Character>();
        for(char x : s.toCharArray()){
            if(x=='(') stack.push(x); // 열린 괄호를 만났을 때
            else { // 닫힌 괄호를 만났을 떄
                if (stack.isEmpty()) return "NO"; // 열린 괄호가 없다 -> 닫힌 괄호랑 쌍을 이룰 열린 괄호가 없다.
                else stack.pop();
            }
        }
        if (stack.isEmpty()) return "YES";
        return answer;
    }
    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(m.solution(str));
    }
}
