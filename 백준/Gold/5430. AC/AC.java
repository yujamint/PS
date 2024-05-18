import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque;
        for (int T = 0; T < t; T++) {
            String fn = br.readLine();
            int n = Integer.parseInt(br.readLine());
            deque = new ArrayDeque<>();
            boolean reverse = false, error = false;
            String input = br.readLine();
            int len = input.length();
            String[] strs = input.substring(1, len - 1).split(",");
            for (int i = 0; i < n; i++) {
                deque.offer(Integer.parseInt(strs[i]));
            }
            for (int i = 0; i < fn.length(); i++) {
                char command = fn.charAt(i);
                if (command == 'R') {
                    reverse = !reverse;
                } else { // 'D'
                    if (deque.isEmpty()) {
                        sb.append("error").append('\n');
                        error = true;
                        break;
                    }
                    if (reverse) deque.pollLast();
                    else deque.pollFirst();
                }
            }
            if (error) continue;
            sb.append('[');
            if (reverse) {
                while (!deque.isEmpty()) {
                    sb.append(deque.pollLast());
                    if (!deque.isEmpty()) sb.append(',');
                }
            } else {
                while (!deque.isEmpty()) {
                    sb.append(deque.pollFirst());
                    if (!deque.isEmpty()) sb.append(',');
                }
            }
            sb.append(']').append('\n');
        }
        System.out.println(sb);
    }

}
