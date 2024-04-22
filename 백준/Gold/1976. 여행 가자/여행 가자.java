import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int connect = Integer.parseInt(st.nextToken());
                if (connect == 1) union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int cur = Integer.parseInt(st.nextToken());
        for (int i = 1; i < m; i++) {
            int next = Integer.parseInt(st.nextToken());
            if (find(cur) != find(next)) {
                System.out.println("NO");
                return;
            }
            cur = next;
        }
        System.out.println("YES");
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return;
        parent[x] = y;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

}
