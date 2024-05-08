import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, r, c, ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        func(n, 0, 0, (int) Math.pow(2, n), (int) Math.pow(2, n));
        System.out.println(ans);
    }

    private static void func(int n, int row1, int col1, int row2, int col2) {
        if (n == 0) return;
        int interval = (row2 - row1) / 2;
        int midRow = row1 + interval;
        int midCol = col1 + interval;

        int temp = (int) Math.pow(2, 2 * n - 2);
        if (midRow > r) {
            if (midCol > c) func(n - 1, row1, col1, midRow, midCol);
            else {
                ans += temp;
                func(n - 1, row1, midCol, midRow, col2);
            }
        }
        else {
            if (midCol > c) {
                ans += temp * 2;
                func(n - 1, midRow, col1, row2, midCol);
            }
            else {
                ans += temp * 3;
                func(n - 1, midRow, midCol, row2, col2);
            }
        }
    }

}
