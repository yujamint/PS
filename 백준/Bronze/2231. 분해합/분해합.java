import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 1; i < n; i++) {
            int sum = i;
            int temp = i;
            while (true) {
                if (temp / 10 == 0) {
                    sum += temp;
                    break;
                }
                int m = temp % 10;
                sum += m;
                temp /= 10;
            }
            if (sum == n) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
