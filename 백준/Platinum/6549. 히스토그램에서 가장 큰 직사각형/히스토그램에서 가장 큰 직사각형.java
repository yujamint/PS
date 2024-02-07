import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static long maxArea;
    static int[] height;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            height = new int[n];
            for (int i = 0; i < n; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(histogram(0, n)).append("\n");
        }
        System.out.println(sb);
    }

    private static long histogram(int start, int end) {
        if (start == end) return 0;
        if (start + 1 == end) return height[start];

        int mid = (start + end) / 2;
        long result = Math.max(histogram(start, mid), histogram(mid, end));

        int left = mid, right = mid, h = height[mid];
        while (right - left + 1 < end - start) {

            int p = left > start ? height[left - 1] : -1;
            int q = right < end - 1 ? height[right + 1] : -1;

            if (p > q) {
                h = Math.min(h, p);
                left--;
            }
            else {
                h = Math.min(h, q);
                right++;
            }
            result = Math.max(result, (long) (right - left + 1) * h);
        }
        return result;

    }
}
