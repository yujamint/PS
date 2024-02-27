import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String explosion = br.readLine();
        int len = explosion.length();
        Stack<Character> stack = new Stack<>();

        char[] chs = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            char ch = chs[i];
            stack.push(ch);

            int size = stack.size();
            if (size >= len) {
                int count = 0;
                for (int j = 1; j <= len; j++) {
                    if (stack.get(size - j) != explosion.charAt(len - j)) break;
                    else count++;
                }

                if (count == len) {
                    for (int j = 0; j < len; j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        }
        else {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            System.out.println(sb.reverse());
        }
    }
}
