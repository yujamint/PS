import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_POSITION = 100_000;

    static boolean[] visited = new boolean[MAX_POSITION + 1];

    static class Pair {

        int position;
        int count;

        public Pair(int position, int count) {
            this.position = position;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(BFS(x, k));
    }

    private static int BFS(int x, int k) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, 0));
        visited[x] = true;
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            if (cur.position == k) {
                return cur.count;
            }

            int np1 = cur.position + 1;
            int np2 = cur.position - 1;
            int np3 = cur.position * 2;
            if (np1 <= MAX_POSITION && !visited[np1]) {
                visited[np1] = true;
                queue.offer(new Pair(np1, cur.count + 1));
            }
            if (np2 >= 0 && !visited[np2]) {
                visited[np2] = true;
                queue.offer(new Pair(np2, cur.count + 1));
            }
            if (cur.position < k && np3 <= MAX_POSITION && !visited[np3]) {
                visited[np3] = true;
                queue.offer(new Pair(np3, cur.count + 1));
            }
        }
        return -1;
    }

}
