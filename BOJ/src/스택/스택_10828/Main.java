package 스택.스택_10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            switch (command) {
                case "push" :
                    int num = Integer.parseInt(input[1]);
                    stack.push(num);
                    break;
                case "pop" :
                    System.out.println(stack.isEmpty() ? -1 : stack.pop());
                    break;
                case "size" :
                    System.out.println(stack.size());
                    break;
                case "empty" :
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;
                case "top" :
                    System.out.println(stack.isEmpty() ? -1 : stack.peek());
                    break;
            }
        }
    }
}
