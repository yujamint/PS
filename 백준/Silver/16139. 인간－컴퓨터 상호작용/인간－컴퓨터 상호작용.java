import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        sum = new int[26][str.length() + 1];
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j < 26; j++) {
                sum[j][i] = sum[j][i - 1];
            }
            sum[str.charAt(i - 1) - 'a'][i]++;
        }
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            sb.append(sum[ch - 'a'][to + 1] - sum[ch - 'a'][from]).append("\n");
        }
        System.out.println(sb);

        br.close();
    }
}
