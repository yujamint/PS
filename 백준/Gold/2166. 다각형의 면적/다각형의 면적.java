import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Point[] arr = new Point[n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Point(x, y);
        }
        arr[n] = arr[0];

        long temp = 0;
        for (int i = 0; i < n; i++) {
            temp += (long) arr[i].x * arr[i + 1].y;
            temp -= (long) arr[i].y * arr[i + 1].x;
        }
        double res = Math.abs(temp) / 2.0;
        System.out.printf("%.1f", res);
    }

}
