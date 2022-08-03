package section10.가장높은탑쌓기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Brick implements Comparable<Brick>{
    int area;
    int height;
    int weight;
    public Brick(int a, int h, int w){
        area = a;
        height = h;
        weight = w;
    }
    public int compareTo(Brick o){
        return o.area - this.area;
    }
}
// 위에 쌓는 돌은 바로 밑의 돌보다 밑면,무게 모두 적어야 된다.
public class Main {
    static int[] dy; // i번째 벽돌이 꼭대기 층인 탑의 최대 높이

    public int solution(ArrayList<Brick> arr) {
        int answer = 0;
        Collections.sort(arr);
        dy[0] = arr.get(0).height;
        for (int i=1; i<arr.size(); i++){
            int max = 0;

            for (int j=i-1; j>=0; j--){
                if(arr.get(j).weight > arr.get(i).weight && dy[j] > max){
                    max = dy[j];
                }
            }
            dy[i] = max + arr.get(i).height;
            answer = Math.max(answer,dy[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n];
        ArrayList<Brick> arr = new ArrayList<>();
        for (int i=0; i<n; i++){
            int a = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Brick(a,h,w));
        }
        System.out.println(T.solution(arr));
    }
}
