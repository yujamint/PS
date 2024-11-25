import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            // window 범위 넘어가는 인덱스 빼기
            while (!deque.isEmpty() && i - deque.peekFirst() + 1 > l) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && arr[deque.peekLast()] > arr[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[deque.peekFirst()]) {
                deque.pollFirst();
            }
            answer[i] = arr[deque.peekFirst()];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(' ');
        }
        System.out.println(sb);
    }
}
