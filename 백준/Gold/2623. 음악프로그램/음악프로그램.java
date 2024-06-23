import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] indegree;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        indegree = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt - 1; j++) {
                int to = Integer.parseInt(st.nextToken());
                graph.get(from).add(to);
                indegree[to]++;
                from = to;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                visited[i] = true;
            }
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int outdegree : graph.get(cur)) {
                indegree[outdegree]--;
            }
            graph.get(cur).clear();

            visited[cur] = true;

            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }

            cnt++;
            sb.append(cur).append('\n');
        }

        if (cnt != n) {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }
    }

}
