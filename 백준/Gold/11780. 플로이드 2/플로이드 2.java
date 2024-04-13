import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] dist = new int[n + 1][n + 1];
        int[][] history = new int[n + 1][n + 1];
        StringTokenizer st;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                else dist[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (dist[start][end] > weight) {
                dist[start][end] = weight;
                history[start][end] = start;
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (i == k) continue;
                for (int j = 1; j <= n; j++) {
                    if (j == k || i == j) continue;
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        history[i][j] = history[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int d = dist[i][j] >= INF ? 0 : dist[i][j];
                sb.append(d).append(' ');
            }
            sb.append('\n');
        }
        Stack<Integer> stack = new Stack<>();
        for (int src = 1; src <= n; src++) {
            for (int dest = 1; dest <= n; dest++) {
                if (dist[src][dest] == 0 || dist[src][dest] == INF)
                    sb.append(0);
                else {
                    int temp = dest;
                    while (temp != 0) {
                        stack.push(temp);
                        temp = history[src][temp];
                    }
                    sb.append(stack.size()).append(' ');
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop()).append(' ');
                    }
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }

}
