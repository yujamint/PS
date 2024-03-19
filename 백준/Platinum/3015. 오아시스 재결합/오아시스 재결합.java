import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static class Pair {
        int height;
        int cnt;

        public Pair(int height, int cnt) {
            this.height = height;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        long cnt = 0;
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            Pair pair = new Pair(arr[i], 1);
            while (!stack.isEmpty() && stack.peek().height <= pair.height) {
                Pair pop = stack.pop();
                cnt += pop.cnt;
                if (pair.height == pop.height) pair.cnt += pop.cnt;
            }

            if (!stack.isEmpty()) cnt++;

            stack.push(pair);
        }
        System.out.println(cnt);
    }
}
