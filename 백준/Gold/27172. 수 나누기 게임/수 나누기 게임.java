import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int SIZE = 1_000_001;
    
    static int n;
    static int[] arr, answer = new int[SIZE];
    static boolean[] card = new boolean[SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            card[arr[i]] = true;
        }

        for (int i : arr) {
            for (int j = 2; i * j < SIZE; j++) {
                int num = i * j;
                if (card[num]) {
                    answer[i]++;
                    answer[num]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[arr[i]]).append(' ');
        }
        System.out.println(sb);
    }

}
