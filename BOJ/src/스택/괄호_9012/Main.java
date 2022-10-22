package 스택.괄호_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static String isVPS(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (c == '(') stack.push(c);
            else {
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }

        if (stack.isEmpty()) return "YES";
        else return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            String result = isVPS(input);
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
