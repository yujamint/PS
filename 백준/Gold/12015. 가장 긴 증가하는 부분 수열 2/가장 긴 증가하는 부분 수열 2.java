import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static List<Integer> lis = new ArrayList<>();
    static int pos = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        lis.add(0);
        for (int i = 0; i < n; i++) {
            if (arr[i] > lis.get(pos)) {
                lis.add(arr[i]);
                pos++;
            } else {
                int idx = binarySearch(1, pos, i);
                lis.set(idx, arr[i]);
            }
        }
        System.out.println(lis.size() - 1);
    }

    private static int binarySearch(int s, int e, int cur) {
        while (s < e) {
            int mid = (s + e) / 2;
            if (lis.get(mid) < arr[cur]) s = mid + 1;
            else e = mid;
        }
        return s;
    }

}
