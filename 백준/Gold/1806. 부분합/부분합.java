import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int answer = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0, rt = 0, sum = arr[0];
        while (true) {
            if (sum >= s) {
                answer = Math.min(answer, (rt - lt) + 1);
                sum -= arr[lt++];
            }
            else if (sum < s) {
                if (rt == arr.length - 1) break;
                sum += arr[++rt];
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}
