import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(input.nextToken());
        int K = Integer.parseInt(input.nextToken());
        if (K > N / 2) {
            K = Math.abs(K - N);
        }

        int result = 1;
        for (int i = 0; i < K; i++) {
            result *= (N - i);
        }
        for (int i = 2; i <= K; i++) {
            result /= i;
        }

        System.out.println(result);
    }
}
