import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, count = 1;
    static int[] ch;
    static List<List<Integer>> edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        ch = new int[n + 1];
        edges = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            edges.get(v1).add(v2);
            edges.get(v2).add(v1);
        }
        for (int i = 1; i <= n; i++) {
            edges.get(i).sort(Comparator.reverseOrder());
        }

        DFS(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(ch[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void DFS(int v) {
        ch[v] = count++;
        List<Integer> edge = edges.get(v);
        for (int i = 0; i < edge.size(); i++) {
            int to = edge.get(i);
            if (ch[to] == 0) {
                DFS(to);
            }
        }
    }

}
