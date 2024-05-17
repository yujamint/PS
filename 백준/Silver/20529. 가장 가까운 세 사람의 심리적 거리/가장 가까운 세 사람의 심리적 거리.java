import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String[] mbti;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int T = 0; T < t; T++) {
            int n = Integer.parseInt(br.readLine());
            mbti = new String[n];
            st = new StringTokenizer(br.readLine());
            if (n >= 33) {
                sb.append(0).append('\n');
                continue;
            }
            for (int i = 0; i < n; i++) {
                mbti[i] = st.nextToken();
            }
            sb.append(solution()).append('\n');
        }
        System.out.println(sb);
    }

    private static int solution() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < mbti.length - 2; i++) {
            String a = mbti[i];
            for (int j = i + 1; j < mbti.length - 1; j++) {
                String b = mbti[j];
                for (int k = j + 1; k < mbti.length; k++) {
                    String c = mbti[k];
                    min = Math.min(min, calculateDistance(a, b, c));
                    if (min == 0) return 0;
                }
            }
        }
        return min;
    }

    private static int calculateDistance(String a, String b, String c) {
        int dist = 0;
        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i)) dist++;
            if (a.charAt(i) != c.charAt(i)) dist++;
            if (b.charAt(i) != c.charAt(i)) dist++;
        }
        return dist;
    }

}
