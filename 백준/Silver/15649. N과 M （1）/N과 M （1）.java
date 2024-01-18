import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        DFS(0, list);
        System.out.println(sb);
    }

    private static void DFS(int count, List<Integer> list) {
        if (count == m) {
            for (Integer integer : list) {
                sb.append(integer).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (list.contains(i)) continue;
            list.add(i);
            DFS(count + 1, list);
            list.remove(Integer.valueOf(i));
        }
    }
}
