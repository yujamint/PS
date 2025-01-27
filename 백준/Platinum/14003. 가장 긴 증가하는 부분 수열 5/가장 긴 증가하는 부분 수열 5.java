import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] arr, rank;
    static List<Integer> lis = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis.add(Integer.MIN_VALUE);
        int pos = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > lis.get(pos)) {
                lis.add(arr[i]);
                pos++;
                rank[i] = pos;
            } else {
                int idx = binarySearch(pos, arr[i]);
                lis.set(idx, arr[i]);
                rank[i] = idx;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lis.size() - 1).append('\n');

        Deque<Integer> stack = new ArrayDeque<>();

        int max = Integer.MAX_VALUE;
        int temp = pos;
        for (int i = n - 1; i >= 0; i--) {
            if (rank[i] == temp && arr[i] < max) {
                stack.push(arr[i]);
                temp--;
                max = arr[i];
            }

            if (temp == 0) {
                break;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }

        System.out.println(sb.toString());
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