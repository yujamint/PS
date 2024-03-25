import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] ladder = new int[101];
    static int[] snake = new int[101];
    static boolean[] visited = new boolean[101];

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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            ladder[from] = to;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            snake[from] = to;
        }

        System.out.println(BFS(1));
    }

    private static int BFS(int start) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(start, 0));
        visited[start] = true;
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            if (cur.position == 100) {
                return cur.count;
            }
            for (int dice = 1; dice <= 6; dice++) {
                int np = cur.position + dice;
                if (np > 100) break;
                if (visited[np]) continue;

                visited[np] = true;

                if (ladder[np] != 0) queue.offer(new Pair(ladder[np], cur.count + 1));
                else if (snake[np] != 0) queue.offer(new Pair(snake[np], cur.count + 1));
                else queue.offer(new Pair(np, cur.count + 1));
            }
        }
        return -1;
    }

}
