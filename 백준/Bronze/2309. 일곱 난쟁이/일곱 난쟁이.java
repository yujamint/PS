import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int len = 9;
    static int[] arr = new int[len];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        int idx1 = 0, idx2 = 0;
        boolean flag = false;
        for (int i = 0; i < len - 1; i++) {
            if (flag) {
                break;
            }
            int h1 = arr[i];
            for (int j = i + 1; j < len; j++) {
                int h2 = arr[j];
                if (sum - (h1 + h2) == 100) {
                    idx1 = i;
                    idx2 = j;
                    flag = true;
                    break;
                }
            }
        }
        int[] answer = new int[7];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (i == idx1 || i == idx2) {
                continue;
            }
            answer[idx++] = arr[i];
        }
        Arrays.sort(answer);
        for (int i = 0; i < 7; i++) {
            sb.append(answer[i]).append('\n');
        }
        System.out.println(sb);
    }
}
