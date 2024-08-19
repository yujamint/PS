import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] indegree, result;
    static List<List<Integer>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        indegree = new int[n + 1];
        result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            indegree[b]++;
        }

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (queue.isEmpty()) {
                System.exit(0);
            }

            int cur = queue.poll();
            result[i] = cur;

            List<Integer> outdegree = graph.get(cur);
            for (int next : outdegree) {
                if (--indegree[next] == 0) queue.offer(next);
            }
        }

        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append(' ');
        }
        System.out.println(sb);
    }
}
