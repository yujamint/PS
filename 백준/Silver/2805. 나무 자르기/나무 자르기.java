import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }
        System.out.println(binarySearch(trees, max));
    }

    private static int binarySearch(int[] trees, int max) {
        int lo = 0, hi = max;
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            long sum = 0;
            for (int tree : trees) {
                sum += Math.max(tree - mid, 0);
            }


            if (sum < m) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo - 1;
    }
}
