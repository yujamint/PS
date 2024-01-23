import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int max;
        int[] arr = new int[n];
        int[] dy = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        max = dy[0] = arr[0];


        for (int i = 1; i < n; i++) {
            dy[i] = Math.max(arr[i], arr[i] + dy[i-1]);
            max = Math.max(max, dy[i]);
        }

        System.out.println(max);

    }
}
