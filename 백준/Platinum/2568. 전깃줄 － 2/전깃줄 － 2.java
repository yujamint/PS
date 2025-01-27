import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Line implements Comparable<Line> {

    int a;
    int b;

    public Line(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Line o) {
        return this.a - o.a;
    }
}

public class Main {

    static List<Line> lis = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Line[] arr = new Line[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new Line(a, b);
        }

        Arrays.sort(arr);

        int[] rank = new int[n];

        lis.add(new Line(0, 0));
        int pos = 0;
        for (int i = 0; i < n; i++) {
            if (lis.get(pos).b < arr[i].b) {
                lis.add(arr[i]);
                pos++;
                rank[i] = pos;
            } else {
                int idx = binarySearch(pos, arr[i].b);
                lis.set(idx, arr[i]);
                rank[i] = idx;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(n - pos).append('\n');

        boolean[] used = new boolean[n];
        int max = Integer.MAX_VALUE;
        int temp = pos;
        for (int i = n - 1; i >= 0; i--) {
            if (rank[i] == temp && arr[i].b < max) {
                used[i] = true;
                temp--;
                max = arr[i].b;
            }

            if (temp == 0) break;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                sb.append(arr[i].a).append('\n');
            }
        }

        System.out.println(sb);
    }

    private static int binarySearch(int end, int cur) {
        int start = 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (lis.get(mid).b < cur) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}
