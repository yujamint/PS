package 스택.쇠막대기_10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        String input = br.readLine();

        int cnt = 0, answer = 0;
        for (Character c : input.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                cnt++;
            }
            else {
                cnt--;
                if (stack.peek() == '(') answer+=cnt;
                else answer++;

                stack.push(c);
            }
        }

        System.out.println(answer);
    }
}
