import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        double max = 0.0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / max * 100;
        }

        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        System.out.println(sum / n);
    }

}
