import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static List<Integer> LIS = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 1;
        LIS.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] > LIS.get(LIS.size() - 1)) {
                LIS.add(arr[i]);
            }

            else {
                int idx = replaceIndex(arr[i]);
                LIS.set(idx, arr[i]);
            }
        }
        System.out.println(LIS.size());
    }

    private static int replaceIndex(int num) {
        int lo = 0, hi = LIS.size();

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (LIS.get(mid) < num) lo = mid + 1;
            else hi = mid;
        }

        return lo;
    }
}
