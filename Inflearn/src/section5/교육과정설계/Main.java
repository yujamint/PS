package section5.교육과정설계;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public String solution(String s1, String s2){
        String answer = "YES";
        Queue<Character> Q = new LinkedList<>();
        for (char x : s2.toCharArray()) Q.offer(x);
        for(char x : s1.toCharArray()){
            if(!Q.contains(x)) return "NO";
            while(Q.poll() != x);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(m.solution(s1,s2));
    }
}
