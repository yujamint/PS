import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static List<Integer> lis = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis.add(0);
        int pos = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > lis.get(pos)) {
                lis.add(arr[i]);
                pos++;
            } else {
                int idx = binarySearch(pos, arr[i]);
                lis.set(idx, arr[i]);
            }
        }
        System.out.println(lis.size() - 1);
    }

    private static int binarySearch(int end, int cur) {
        int start = 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (lis.get(mid) < cur) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}
