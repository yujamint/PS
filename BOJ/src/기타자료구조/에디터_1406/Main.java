package 기타자료구조.에디터_1406;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack1.push(input.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            char c = str.charAt(0);

            switch (c) {
                case 'L':
                    if (!stack1.isEmpty()) stack2.push(stack1.pop());
                    break;
                case 'D':
                    if (!stack2.isEmpty()) stack1.push(stack2.pop());
                    break;
                case 'B':
                    if (!stack1.isEmpty()) stack1.pop();
                    break;
                case 'P':
                    stack1.push(str.charAt(2));
                    break;
            }
        }

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        for (char c : stack1) {
            bw.write(c);
        }

        bw.flush();
        bw.close();
    }
}