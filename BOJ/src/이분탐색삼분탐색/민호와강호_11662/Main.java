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

        double min = calculateDistance(aX1, aY1, cX1, cY1);
        for (int i = 1; i <= interval; i++) {
            double temp = calculateDistance(aX1 + aDX * i, aY1 + aDY * i, cX1 + cDX * i, cY1 + cDY * i);

            min = Math.min(temp, min);
        }

        System.out.printf("%.10f", min);
    }
}
