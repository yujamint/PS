import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int lo = 0, hi = n - 1;
        int loAnswer = 0, hiAnswer = 0;
        while (lo < hi) {
            int sum = arr[lo] + arr[hi];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                loAnswer = arr[lo];
                hiAnswer = arr[hi];
            }
            
            if (sum == 0) {
                break;
            } else if (sum > 0) {
                hi--;
            } else {
                lo++;
            }
        }

        System.out.println(loAnswer + " " + hiAnswer);
    }

}