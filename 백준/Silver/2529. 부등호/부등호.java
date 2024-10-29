import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int len;
    static long max = Long.MIN_VALUE, min = Long.MAX_VALUE;
    static char[] arr;
    static int[] nums;
    static boolean[] check = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        len = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new char[len];
        nums = new int[len + 1];
        for (int i = 0; i < len; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        DFS(0, len);
        String maxStr = String.valueOf(max);
        String minStr = String.valueOf(min);
        if (maxStr.length() < nums.length) {
            maxStr = '0' + maxStr;
        }
        if (minStr.length() < nums.length) {
            minStr = '0' + minStr;
        }
        System.out.println(maxStr);
        System.out.println(minStr);
    }

    private static void DFS(int cur, int n) {
        if (cur > n) {
            if (isValid()) {
                long result = 0;
                for (int i = 0; i < n + 1; i++) {
                    if (i != 0) {
                        result *= 10;
                    }
                    result += nums[i];
                }
                max = Math.max(max, result);
                min = Math.min(min, result);
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (!check[i]) {
                check[i] = true;
                nums[cur] = i;
                DFS(cur + 1, n);
                check[i] = false;
            }
        }
    }

    private static boolean isValid() {
        for (int i = 0; i < len; i++) {
            switch (arr[i]) {
                case '<':
                    if (nums[i] > nums[i + 1]) return false;
                    break;
                case '>':
                    if (nums[i] < nums[i + 1]) return false;
                    break;
            }
        }
        return true;
    }
}
