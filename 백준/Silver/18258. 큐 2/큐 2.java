import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int last = 0;
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            int result = Integer.MIN_VALUE;
            switch (command) {
                case "push":
                    int param = Integer.parseInt(input[1]);
                    queue.add(param);
                    last = param;
                    break;
                case "pop":
                    result = queue.isEmpty() ? -1 : queue.poll();
                    break;
                case "size":
                    result = queue.size();
                    break;
                case "empty":
                    result = queue.isEmpty() ? 1 : 0;
                    break;
                case "front":
                    result = queue.isEmpty() ? -1 : queue.peek();
                    break;
                case "back":
                    result = queue.isEmpty() ? -1 : last;
                    break;
            }
            if (result != Integer.MIN_VALUE) sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
