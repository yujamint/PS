import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int len = Integer.parseInt(br.readLine());
        int ioi = 3 + (n - 1) * 2;
        String s = br.readLine();
        Deque<Character> deque = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == 'I') {
                if (!deque.isEmpty() && deque.peek() == 'I') deque.clear();
                deque.push(c);
            }
            else {
                if (!deque.isEmpty() && deque.peek() == 'I') deque.push(c);
                else deque.clear();
            }
            if (deque.size() == ioi) {
                count++;
                deque.pollFirst();
                deque.pollFirst();
            }
        }
        System.out.println(count);
    }

}
