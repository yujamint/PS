import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();
    static Set<String> answer = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        visited = new boolean[n];
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        BFS(0);
        StringBuilder sb = new StringBuilder();
        for (String s : answer) {
            sb.append(s).append('\n');
        }
        System.out.println(sb);
    }

    private static void BFS(int cnt) {
        if (cnt == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(list.get(i)).append(' ');
            }
            answer.add(sb.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            list.add(arr[i]);
            BFS(cnt + 1);
            list.remove(cnt);
            visited[i] = false;
        }
    }

}
