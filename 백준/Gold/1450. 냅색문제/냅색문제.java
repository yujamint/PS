import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] front;
    static int[] rear;
    static List<Long> frontSum = new ArrayList<Long>();
    static List<Long> rearSum = new ArrayList<Long>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        front = new int[n / 2];
        rear = new int[n - n / 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < front.length; i++) {
            front[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < rear.length; i++) {
            rear[i] = Integer.parseInt(st.nextToken());
        }

        DFS(front, frontSum, 0, 0);
        DFS(rear, rearSum, 0, 0);

        Collections.sort(frontSum);
        Collections.sort(rearSum);

        int count = 0;
        for (int i = 0; i < frontSum.size(); i++) {
            Long frontValue = frontSum.get(i);
            int lo = 0, hi = rearSum.size();
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                long sum = frontValue + rearSum.get(mid);

                if (sum <= c) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            count += lo;
        }

        System.out.println(count);
    }

    private static void DFS(int[] arr, List<Long> sumList, int cnt, long sum) {
        if (cnt == arr.length) {
            sumList.add(sum);
            return;
        }
        DFS(arr, sumList, cnt + 1, sum + arr[cnt]);
        DFS(arr, sumList, cnt + 1, sum);
    }

}
