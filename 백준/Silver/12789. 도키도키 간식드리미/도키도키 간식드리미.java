import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int nextOrder = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (numbers[i] == nextOrder) {
                nextOrder++;
                while (!stack.isEmpty()) {
                    if (stack.peek() != nextOrder) {
                        break;
                    }
                    stack.pop();
                    nextOrder++;
                }
                continue;
            }
            stack.push(numbers[i]);
        }

        while (!stack.isEmpty()) {
            if (stack.pop() == nextOrder) {
                nextOrder++;
                continue;
            }
            System.out.println("Sad");
            return;
        }
        System.out.println("Nice");
    }
}
