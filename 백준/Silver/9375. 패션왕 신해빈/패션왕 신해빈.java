import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int T = 0; T < t; T++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String category = br.readLine().split(" ")[1];
                map.put(category, map.getOrDefault(category, 0) + 1);
            }
            int ans = 1;
            for (int num : map.values()) {
                ans *= (num + 1);
            }
            sb.append(ans - 1).append('\n');
        }
        System.out.println(sb);
    }

}
