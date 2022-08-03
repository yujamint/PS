package section8.피자배달거리;

import java.util.ArrayList;
import java.util.Scanner;

class Point{
    int x,y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n,m,answer=Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<Point> pizza = new ArrayList<>();
    static ArrayList<Point> home = new ArrayList<>();

    public void DFS(int L, int start){
        if(L==m){
            int sum = 0;
            for(Point h : home){
                int dis = Integer.MAX_VALUE;
                for(int c : combi){
                    Point p = pizza.get(c);
                    dis = Math.min(Math.abs(h.x - p.x) + Math.abs(h.y-p.y), dis);
                }
                sum += dis;
            }
            answer = Math.min(answer,sum);
        }
        else {
            for(int i=start; i<pizza.size(); i++){
                combi[L] = i;
                DFS(L+1, i+1); // 다음으로 없앨 피자집 정하기 위해 재귀호출
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combi = new int[m];
        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int temp = sc.nextInt();
                if(temp == 2) pizza.add(new Point(i, j));
                else if(temp == 1) home.add(new Point(i,j));
            }
        }
        T.DFS(0,0);
        System.out.println(answer);
    }
}
