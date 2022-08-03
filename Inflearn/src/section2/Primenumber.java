package section2;

import java.util.Scanner;

public class Primenumber {
    public int solution(int n){
        int answer = 0;
        for (int i=2; i<n; i++){
            int divided = 1;
            for (int j=1; j<=Math.sqrt(i); j++)
                if (i%j==0) divided = j;
            if(divided == 1) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Primenumber p = new Primenumber();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(p.solution(n));
    }
}
