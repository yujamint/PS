import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int t = 1;
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> graph;
    static boolean[] visited;
    static boolean isCycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            visited = new boolean[n + 1];
            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph.get(from).add(to);
                graph.get(to).add(from);
            }

            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (visited[i]) continue;
                DFS(0, i);
                if (isCycle) {
                    isCycle = false;
                    continue;
                }
                count++;
            }

            String result = convertCountToResult(count);
            sb.append("Case ").append(t++).append(": ").append(result).append('\n');
        }
        System.out.println(sb);
    }

    private static String convertCountToResult(int count) {
        switch (count) {
            case 0:
                return "No trees.";
            case 1:
                return "There is one tree.";
            default:
                return String.format("A forest of %d trees.", count);
        }
    }

    private static void DFS(int prev, int cur) {
        visited[cur] = true;

        for (int next : graph.get(cur)) {
            if (next == prev) continue;
            if (visited[next]) { // cycle이 존재한다.
                isCycle = true;
                continue;
            }
            DFS(cur, next);
        }
    }

}
