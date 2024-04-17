import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] rank = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>();
        lis.add(Integer.MIN_VALUE);
        for (int i = 1; i <= n; i++) {
            int lastIdx = lis.size() - 1;
            if (lis.get(lastIdx) < arr[i]) {
                lis.add(arr[i]);
                rank[i] = lis.size() - 1;
            }
            else {
                // arr[i]가 가야할 위치는?? lis의 원소 중, arr[i] 이상이면서 제일 작은 원소
                // lis[mid] < arr[i] lis[mid]를 더 키워야 한다.
                // lis[mid] >= arr[i] 더 작은 애가 있나 찾아야 한다. mid를 조금씩 낮춰본다. -> hi = mid
                int lo = 1, hi = lastIdx;
                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    if (lis.get(mid) >= arr[i]) {
                        hi = mid;
                    } else {
                        lo = mid + 1;
                    }
                }
                lis.set(lo, arr[i]);
                rank[i] = lo;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lis.size() - 1).append('\n');

        int temp = lis.size() - 1;
        int max = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i > 0; i--) {
            if (rank[i] == temp && arr[i] < max) {
                stack.push(arr[i]);
                temp--;
                max = arr[i];
            }
            if (temp == 0) break;
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }
        System.out.println(sb);
    }

}
