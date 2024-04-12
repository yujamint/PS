import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                answer.add(str);
            }
        }
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append('\n');
        for (String s : answer) {
            sb.append(s).append('\n');
        }
        System.out.println(sb);
    }

}
