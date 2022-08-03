package section9.최대수입스케쥴;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture>{
    int money, day;
    public Lecture(int money, int day){
        this.money = money;
        this.day = day;
    }
    @Override
    public int compareTo(Lecture o) {
        return o.day - this.day;
    }
}

public class Main {
    static int n, max = Integer.MIN_VALUE;

    public int solution(ArrayList<Lecture> list){
        int answer=0;
        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int j=0;
        for(int i=max; i>=1; i--){
            for( ; j<n; j++){
                if(list.get(j).day < i) break;
                pq.offer(list.get(j).money);
            }
            if(!pq.isEmpty()) answer += pq.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ArrayList<Lecture> list = new ArrayList<>(n);
        for(int i=0; i<n; i++){
            int money = sc.nextInt();
            int day = sc.nextInt();
            list.add(new Lecture(money, day));
            max = Math.max(max, day);
        }
        System.out.println(T.solution(list));
    }
}
