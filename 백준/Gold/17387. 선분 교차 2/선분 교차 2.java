import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Point A = new Point(
            Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken())
        );
        Point B = new Point(
            Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken())
        );

        st = new StringTokenizer(br.readLine());
        Point C = new Point(
            Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken())
        );
        Point D = new Point(
            Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken())
        );

        Line line1 = new Line(A, B);
        Line line2 = new Line(C, D);

        int c1 = ccw(line1.p1, line1.p2, line2.p1);
        int c2 = ccw(line1.p1, line1.p2, line2.p2);
        int c3 = ccw(line2.p1, line2.p2, line1.p1);
        int c4 = ccw(line2.p1, line2.p2, line1.p2);

        if (c1 != c2 && c3 != c4) {
            System.out.println(1);
            return;
        }

        if (c1 == 0 && c2 == 0 && c3 == 0 && c4 == 0) {
            if (line1.p1.compareTo(line2.p2) <= 0 && line2.p1.compareTo(line1.p2) <= 0) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    private static int ccw(Point p1, Point p2, Point p3) {
        /*
        p1p2 벡터와 p1p3 벡터의 외적 값의 부호를 반환한다.
        양수 -> CW(시계방향)
        음수 -> CCW(반시계방향)
        0 -> 한 선분 위에 존재한다.
         */
        Point[] arr = {p1, p2, p3, p1};
        long sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += (long) arr[i].x * arr[i + 1].y - (long) arr[i].y * arr[i + 1].x;
        }
        if (sum > 0) {
            return 1;
        } else if (sum < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) {
            return this.y - o.y;
        }
        return this.x - o.x;
    }
}

class Line {
    Point p1, p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1.compareTo(p2) <= 0 ? p1 : p2;
        this.p2 = p1.compareTo(p2) <= 0 ? p2 : p1;
    }
}
