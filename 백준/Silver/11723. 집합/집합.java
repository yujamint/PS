import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int param = 0;
            if (st.hasMoreTokens()) {
                param = Integer.parseInt(st.nextToken());
            }
            switch (command) {
                case "add":
                    set.add(param);
                    break;
                case "remove":
                    set.remove(param);
                    break;
                case "check":
                    sb.append(set.contains(param) ? 1 : 0).append('\n');
                    break;
                case "toggle":
                    if (set.contains(param)) set.remove(param);
                    else set.add(param);
                    break;
                case "all":
                    set = new HashSet<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                            11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        System.out.println(sb);
    }

}
