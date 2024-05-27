import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 65 && c <= 90) { // 알파벳이라면
                sb.append(c);
            }
            else { // 기호라면
                if (stack.isEmpty() || (c != ')' && stack.peek() == '(')) { // 스택이 비어 있다면 바로 삽입
                    stack.push(c);
                } else { // 스택이 비어 있지 않다면 우선순위 따져보자.
                    // peek이 우선순위가 낮은 것이라면 계속 스택에 쌓자.
                    if (c == '(') {
                        stack.push(c);
                    } else if (c == ')') {
                        char temp;
                        while ((temp = stack.pop()) != '(') {
                            sb.append(temp);
                        }
                    } else if (c == '+' || c == '-') {
                        while (!stack.isEmpty() && stack.peek() != '(') {
                            sb.append(stack.pop());
                        }
                        stack.push(c);
                    } else if (c == '*' || c == '/') {
                        while (!stack.isEmpty() && stack.peek() != '(' && stack.peek() != '+' && stack.peek() != '-') {
                            sb.append(stack.pop());
                        }
                        stack.push(c);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            char pop = stack.pop();
            if (pop != '(' && pop != ')') {
                sb.append(pop);
            }
        }
        System.out.println(sb);
    }

}
