import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (!(input = br.readLine()).equals("0 0 0")) {
            st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a > b && a > c) {
                String res = Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2) ? "right" : "wrong";
                sb.append(res).append('\n');
                continue;
            }
            if (b > a && b > c) {
                String res = Math.pow(b, 2) == Math.pow(a, 2) + Math.pow(c, 2) ? "right" : "wrong";
                sb.append(res).append('\n');
                continue;
            }
            if (c > a && c > b) {
                String res = Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2) ? "right" : "wrong";
                sb.append(res).append('\n');
                continue;
            }
            sb.append("wrong").append('\n');
        }
        System.out.println(sb);
    }

}
