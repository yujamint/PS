import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] weights = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] marbles = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            marbles[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>();
        set.add(weights[0]);
        for (int i = 1; i < n; i++) {

            List<Integer> list = new ArrayList<>();
            for (Integer num : set) {
                list.add(num + weights[i]);
                list.add(Math.abs(weights[i] - num));
                list.add(weights[i]);
            }
            set.addAll(list);

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            char result = set.contains(marbles[i]) ? 'Y' : 'N';
            sb.append(result).append(" ");
        }

        System.out.println(sb);
    }
}
