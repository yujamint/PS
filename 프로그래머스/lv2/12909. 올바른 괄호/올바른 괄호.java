import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        boolean answer = false;

        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (stack.isEmpty()) {
                    System.out.println(answer);
                    return answer;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        answer = stack.isEmpty();
        System.out.println(answer);
        return answer;
    }
}