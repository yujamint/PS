import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int[] time = new int[100_001];
    static int[] parent = new int[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        BFS(n, k);

        StringBuilder sb = new StringBuilder();
        sb.append(time[k] - 1).append('\n');
        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        int idx = k;

        while (idx != n) {
            stack.push(parent[idx]);
            idx = parent[idx];
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }
        System.out.println(sb);
    }

    private static void BFS(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        time[n] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == k) {
                return;
            }

            for (int i = 0; i < 3; i++) {
                int next = cur;
                if (i == 0) next += 1;
                else if (i == 1) next -= 1;
                else next *= 2;

                if (next > 100_000 || next < 0 || time[next] != 0) continue;

                queue.offer(next);
                time[next] = time[cur] + 1;
                parent[next] = cur;
            }
        }
    }
}
