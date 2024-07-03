import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long absMin = Long.MAX_VALUE;
    static int[] arr, answer = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                // sum + arr[k]가 0에 가까운 k를 이분 탐색으로 찾는다.
                binarySearch(i, j);
            }
        }
        System.out.printf("%d %d %d", arr[answer[0]], arr[answer[1]], arr[answer[2]]);
    }

    private static void binarySearch(int idx1, int idx2) {
        long temp = arr[idx1] + arr[idx2];
        int lo = idx2 + 1;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            long sum = temp + arr[mid];
            if (Math.abs(sum) < absMin) {
                absMin = Math.abs(sum);
                answer[0] = idx1;
                answer[1] = idx2;
                answer[2] = mid;
            }

            if (sum > 0) {
                hi = mid - 1;
            }
            else if (sum < 0) {
                lo = mid + 1;
            }
            else {
                System.out.printf("%d %d %d", arr[idx1], arr[idx2], arr[mid]);
                System.exit(0);
            }
        }
    }

}
