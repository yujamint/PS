import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < n + 2; i++) {
            int num = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] > num) {
                int top = stack.pop();
                maxArea = Math.max(maxArea, arr[top] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        System.out.println(maxArea);
    }

}
