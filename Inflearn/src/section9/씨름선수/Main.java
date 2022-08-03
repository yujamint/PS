package section9.씨름선수;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Body implements Comparable<Body>{
    int height, weight;
    public Body(int height, int weight){
        this.height = height;
        this.weight = weight;
    }
    @Override
    public int compareTo(Body o) {
        return o.height - this.height;
    }
}

public class Main {

    public int solution(int n, ArrayList<Body> list){
        int answer = 0;
        Collections.sort(list);
        int max = Integer.MIN_VALUE;
        for(Body ob : list){
            if(ob.weight > max) {
                max = ob.weight;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        ArrayList<Body> list = new ArrayList<>(n);
        for (int i=0; i<n; i++){
            int h = sc.nextInt();
            int w = sc.nextInt();
            list.add(new Body(h,w));
        }
        System.out.println(T.solution(n, list));
    }
}
