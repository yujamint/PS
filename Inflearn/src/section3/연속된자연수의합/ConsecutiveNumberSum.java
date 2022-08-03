package section3.연속된자연수의합;

import java.util.Scanner;

public class ConsecutiveNumberSum {
    public int solution(int n){
        int answer = 0, cnt=1;
        n--;
        while(n>0) {
            cnt++;
            n -= cnt;
            if (n%cnt==0) answer++;
        }
        return answer;
//        int answer = 0;
//        int lt=0;
//        int sum = 0;
//        for(int rt=1; rt<n; rt++){
//            if (sum == n)
//                answer++;
//            sum += rt;
//                while(sum > n){
//                    lt++;
//                    sum-=lt;
//            }
//        }
//        return answer;
    }

    public static void main(String[] args) {
        ConsecutiveNumberSum m = new ConsecutiveNumberSum();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(m.solution(n));
    }
}
