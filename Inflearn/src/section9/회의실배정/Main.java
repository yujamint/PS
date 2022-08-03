package section9.회의실배정;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time>{
    int start, end;
    public Time(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Time o) {
        if(o.end == this.end) return this.start - o.start;
        return this.end - o.end;
    }
}

public class Main {
    public int solution(int n, ArrayList<Time> list){
        int answer = 0, s = 0;
        Collections.sort(list);
        for (Time ob : list){
            if(ob.start >= s) {
                s = ob.end;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> list = new ArrayList<>(n);
        for (int i=0; i<n; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new Time(s,e));
        }
        System.out.println(T.solution(n,list));
    }
}
