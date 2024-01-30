import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        sum = new int[str.length() + 1][26];
        for (int i = 1; i <= str.length(); i++) {
            for (int j = i; j <= str.length(); j++) {
                sum[j][str.charAt(i - 1) - 'a']++;
            }
        }
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            sb.append(sum[to + 1][ch - 'a'] - sum[from][ch - 'a']).append("\n");
        }
        System.out.println(sb);
    }
}
