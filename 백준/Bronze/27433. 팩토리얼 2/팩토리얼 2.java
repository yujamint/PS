import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 1;
        System.out.println(factorial(answer, N));
    }

    private static long factorial(long answer, int n) {
        if (n == 0) {
            return answer;
        }
        return factorial(answer * n, n - 1);
    }
}
