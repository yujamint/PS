import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] aInput = br.readLine().split(" ");
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(aInput[i]);
        }

        String[] bInput = br.readLine().split(" ");
        int[] b = new int[N];
        for (int i = 0; i < N; i++) {
            b[i] = Integer.parseInt(bInput[i]);
        }

        int M = Integer.parseInt(br.readLine());
        String[] cInput = br.readLine().split(" ");
        int[] c = new int[M];
        for (int i = 0; i < M; i++) {
            c[i] = Integer.parseInt(cInput[i]);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (a[i] == 0) {
                deque.offerLast(b[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            deque.offerFirst(c[i]);
            sb.append(deque.pollLast()).append(" ");
        }
        System.out.println(sb);
    }

}
