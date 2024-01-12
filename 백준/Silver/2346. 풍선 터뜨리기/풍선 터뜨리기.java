import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] numbers = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(input[i - 1]);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        Integer balloon = deque.pollFirst();
        StringBuilder sb = new StringBuilder(String.valueOf(balloon));
        while (!deque.isEmpty()) {
            int move = numbers[balloon];
            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    deque.offerLast(deque.pollFirst());
                }
                balloon = deque.pollFirst();
            }
            if (move < 0) {
                for (int i = 0; i < Math.abs(move) - 1; i++) {
                    deque.offerFirst(deque.pollLast());
                }
                balloon = deque.pollLast();
            }
            sb.append(" ").append(balloon);
        }
        System.out.println(sb);
    }
}
