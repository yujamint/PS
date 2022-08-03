package section9.결혼식;

import java.util.*;

class Time implements Comparable<Time>{
    int t;
    char s;
    public Time(int t, char s){
        this.t = t;
        this.s = s;
    }
    @Override
    public int compareTo(Time o){
        if(this.t == o.t) return this.s - o.s;
        else return this.t - o.t;
    }
}

public class Main {
    public int solution(ArrayList<Time> list) {
        Collections.sort(list);
        int answer = Integer.MIN_VALUE, cnt = 0;
        for(Time ob : list) {
            if(ob.s == 's') cnt++;
            else cnt--;
            answer = Math.max(answer,cnt);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> list = new ArrayList<>(n);
        for (int i=0; i<n; i++){
            int come = sc.nextInt();
            int go = sc.nextInt();
            list.add(new Time(come, 's'));
            list.add(new Time(go, 'e'));
        }
        System.out.println(T.solution(list));
    }
}
