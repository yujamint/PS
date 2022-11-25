package 이분탐색삼분탐색.민호와강호_11662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static double calculateDistance(double ax, double ay, double bx, double by) {
        return Math.sqrt(Math.pow(bx - ax, 2) + Math.pow(by - ay, 2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        double aX1 = Double.parseDouble(st.nextToken());
        double aY1 = Double.parseDouble(st.nextToken());
        double aX2 = Double.parseDouble(st.nextToken());
        double aY2 = Double.parseDouble(st.nextToken());

        double cX1 = Double.parseDouble(st.nextToken());
        double cY1 = Double.parseDouble(st.nextToken());
        double cX2 = Double.parseDouble(st.nextToken());
        double cY2 = Double.parseDouble(st.nextToken());

        int interval = 1_000_000;

        double aDX = (aX2 - aX1) / interval;
        double aDY = (aY2 - aY1) / interval;
        double cDX = (cX2 - cX1) / interval;
        double cDY = (cY2 - cY1) / interval;

        int lo = 0;
        int hi = interval;

        while (hi - lo >= 3) {
            int p = (2 * lo + hi) / 3;
            int q = (lo + 2 * hi) / 3;

            double mid1 = calculateDistance(aX1 + aDX * p,aY1 + aDY * p, cX1 + cDX * p, cY1 + cDY * p);
            double mid2 = calculateDistance(aX1 + aDX * q, aY1 + aDY * q, cX1 + cDX * q, cY1 + cDY * q);

            if (mid1 > mid2) {
                lo = p + 1;
            } else {
                hi = q - 1;
            }
        }

        double min = calculateDistance(aX1 + aDX * hi,aY1 + aDY * hi, cX1 + cDX * hi, cY1 + cDY * hi);
        for (int i = lo; i < hi; i++) {
            double temp = calculateDistance(aX1 + aDX * i,aY1 + aDY * i, cX1 + cDX * i, cY1 + cDY * i);

            min = Math.min(min, temp);
        }

        System.out.printf("%.10f", min);
    }
}