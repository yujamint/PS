package 완전탐색.로고_3108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Rectangle{
    int x1, x2, y1, y2;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
}

public class Main {
    static int n, PU = 0;
    static Rectangle[] rectangles;
    static boolean[] visited;
    static Queue<Rectangle> q = new LinkedList<>();

    public static boolean meet(Rectangle a, Rectangle b) {
        boolean outside = a.x1 > b.x2 || a.x2 < b.x1 || a.y1 > b.y2 || a.y2 < b.y1;
        boolean bInA = a.x1 < b.x1 && a.y1 < b.y1 && a.x2 > b.x2 && a.y2 > b.y2;
        boolean aInB = a.x1 > b.x1 && a.y1 > b.y1 && a.x2 < b.x2 && a.y2 < b.y2;

        if (outside || bInA || aInB) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        rectangles = new Rectangle[n+1];
        visited = new boolean[n+1];

        rectangles[0] = new Rectangle(0, 0, 0, 0);
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            Rectangle rectangle = new Rectangle(x1, y1, x2, y2);
            rectangles[i] = rectangle;
        }

        for (int i = 0; i <= n; i++) {
            if (visited[i]) continue;

            visited[i] = true;

            Rectangle a = rectangles[i];
            q.offer(a);

            while (!q.isEmpty()) {
                Rectangle cur = q.poll();
                for (int j = 0; j <= n; j++) {
                    Rectangle b = rectangles[j];

                    if (cur == b || visited[j] || !meet(cur,b)) continue;

                    visited[j] = true;
                    q.offer(b);
                 }
            }
            PU++;
        }

        System.out.println(PU-1);
    }
}
