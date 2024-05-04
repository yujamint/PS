import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long gcd = 1;
        if (a > b) gcd = euclidean(a, b);
        else gcd = euclidean(b, a);
        System.out.println(a * b / gcd);
    }

    private static long euclidean(long a, long b) {
        long r = a % b;
        if (r == 0) return b;
        else return euclidean(b, r);
    }

}
