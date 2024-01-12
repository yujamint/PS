import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int command = Integer.parseInt(input[0]);
            int result = Integer.MIN_VALUE;
            switch (command) {
                case 1:
                    deque.addFirst(Integer.parseInt(input[1]));
                    break;
                case 2:
                    deque.addLast(Integer.parseInt(input[1]));
                    break;
                case 3:
                    result = deque.isEmpty() ? -1 : deque.pollFirst();
                    break;
                case 4:
                    result = deque.isEmpty() ? -1 : deque.pollLast();
                    break;
                case 5:
                    result = deque.size();
                    break;
                case 6:
                    result = deque.isEmpty() ? 1 : 0;
                    break;
                case 7:
                    result = deque.isEmpty() ? -1 : deque.getFirst();
                    break;
                case 8:
                    result = deque.isEmpty() ? -1 : deque.getLast();
                    break;
            }
            if (result != Integer.MIN_VALUE) sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
