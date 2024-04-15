import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> numberByName = new HashMap<>();
        Map<Integer, String> nameByNumber = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            numberByName.put(input, i);
            nameByNumber.put(i, input);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            if (input.charAt(0) >= 65) {
                sb.append(numberByName.get(input));
            } else {
                sb.append(nameByNumber.get(Integer.parseInt(input)));
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

}
