import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] kevinBacon;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        kevinBacon = new int[n + 1];
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int min = 1;
        for (int i = 1; i <= n; i++) {
            kevinBacon[i] = BFS(i);
            if (kevinBacon[min] > kevinBacon[i]) {
                min = i;
            }
        }
        System.out.println(min);
    }

    private static int BFS(int x) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[x] = true;
        queue.offer(new int[]{x, 0});
        int kbNum = 0;
        int friendCount = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            kbNum += cur[1];
            friendCount++;
            if (friendCount == n) break;
            List<Integer> friends = graph.get(cur[0]);
            for (int friend : friends) {
                if (visited[friend]) continue;
                queue.offer(new int[]{friend, cur[1] + 1});
                visited[friend] = true;
            }
        }
        return kbNum;
    }

}
