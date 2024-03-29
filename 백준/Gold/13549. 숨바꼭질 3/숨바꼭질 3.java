import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = Integer.MAX_VALUE;

    static int[] dist = new int[200_001];
    static boolean[] visited = new boolean[200_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Arrays.fill(dist, INF);

        dist[n] = 0;
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return dist[o1] - dist[o2];
            }
        });
        queue.offer(n);
        while (!queue.isEmpty()) {
            int cur;
            do {
                cur = queue.poll();
            } while (!queue.isEmpty() && visited[cur]);
            if (visited[cur]) break;

            visited[cur] = true;

            if (cur + 1 < dist.length && dist[cur + 1] > dist[cur] + 1) {
                dist[cur + 1] = dist[cur] + 1;
                queue.offer(cur + 1);
            }
            if (cur - 1 >= 0 && dist[cur - 1] > dist[cur] + 1) {
                dist[cur - 1] = dist[cur] + 1;
                queue.offer(cur - 1);
            }
            if (cur * 2 < dist.length && dist[cur * 2] > dist[cur]) {
                dist[cur * 2] = dist[cur];
                queue.offer(cur * 2);
            }
        }

        System.out.println(dist[k]);
    }

}
