import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int index;
    static Map<String, Integer> indexByName;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int T = 0; T < t; T++) {
            indexByName = new HashMap<>();
            index = 0;
            int f = Integer.parseInt(br.readLine());
            parent = new int[2 * f];
            Arrays.fill(parent, -1);
            for (int i = 0; i < f; i++) {
                st = new StringTokenizer(br.readLine());
                String x = st.nextToken();
                if (!indexByName.containsKey(x)) {
                    indexByName.put(x, index++);
                }
                String y = st.nextToken();
                if (!indexByName.containsKey(y)) {
                    indexByName.put(y, index++);
                }
                int xIdx = indexByName.get(x);
                int yIdx = indexByName.get(y);
                union(xIdx, yIdx);
                sb.append(Math.abs(parent[find(xIdx)])).append('\n');
            }
        }
        System.out.println(sb);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return;
        parent[x] += parent[y];
        parent[y] = x;
    }

    private static int find(int x) {
        if (parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }

}
