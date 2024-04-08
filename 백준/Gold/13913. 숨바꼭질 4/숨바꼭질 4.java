import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static class Pair {
        int count;
        int cur;

        public Pair(int count, int cur) {
            this.count = count;
            this.cur = cur;
        }
    }

    static int[] visited = new int[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Arrays.fill(visited, -1);

        int count = BFS(n, k);

        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n');
        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        count--;
        while (stack.peek() != n) {
            int cur = stack.peek();
            if (cur + 1 <= 100_000 && visited[cur + 1] == count) {
                stack.push(cur + 1);
                count--;
                continue;
            }
            if (cur - 1 >= 0 && visited[cur - 1] == count) {
                stack.push(cur - 1);
                count--;
                continue;
            }
            if (visited[cur / 2] == count) {
                stack.push(cur / 2);
                count--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }
        System.out.println(sb);
    }

    private static int BFS(int n, int k) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, n));
        visited[n] = 0;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int cur = pair.cur, count = pair.count;
            if (cur == k) {
                return pair.count;
            }
            if (cur + 1 <= 100_000 && visited[cur + 1] == -1) {
                queue.offer(new Pair(count + 1, cur + 1));
                visited[cur + 1] = count + 1;
            }
            if (cur - 1 >= 0 && visited[cur - 1] == -1) {
                queue.offer(new Pair(count + 1, cur - 1));
                visited[cur - 1] = count + 1;
            }
            if (cur * 2 <= 100_000 && visited[cur * 2] == -1) {
                queue.offer(new Pair(count + 1, cur * 2));
                visited[cur * 2] = count + 1;
            }
        }
        return -1;
    }

}
