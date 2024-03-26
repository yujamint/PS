import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int RED = -1;
    private static final int BLUE = 1;

    static int k, v, e;
    static int[] color;
    static List<List<Integer>> graph;
    static Queue<Integer> queue;
    static boolean isBipartite;

    public static void BFS(int start) {
        queue = new LinkedList<>();

        queue.offer(start);
        color[start] = RED;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int node : graph.get(cur)) {
                if (color[node] == 0) {
                    color[node] = -1 * color[cur];
                    queue.offer(node);
                }
                if (color[node] == color[cur]) {
                    isBipartite = false;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());

        for (int test = 0; test < k; test++) {
            isBipartite = true;
            st = new StringTokenizer(br.readLine(), " ");
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            color = new int[v + 1];
            graph = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                graph.add(new ArrayList<>());
            }

            for (int edge = 0; edge < e; edge++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            for (int i = 1; i <= v; i++) {
                if (!isBipartite) {
                    break;
                }
                if (color[i] == 0) {
                    BFS(i);
                }
            }
            sb.append(isBipartite ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);
    }
}
