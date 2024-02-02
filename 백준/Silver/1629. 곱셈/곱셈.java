import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        long res = divide(a, b);
        System.out.println(res);
    }

    private static long divide(int a, int exponent) {
        if (exponent == 1) {
            return a % c;
        }

        long temp = divide(a, exponent / 2);

        if (exponent % 2 == 0) return (temp % c * temp % c) % c;
        else return ((temp % c * temp % c) * a % c) % c;
    }
}
