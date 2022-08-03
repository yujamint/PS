package section2;
//배열 사용하지 않고 a,b,c로 옮겨가면서도 가능

import java.util.Scanner;

public class Fibonacci {
    public int[] solution(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for(int i=2; i<n; i++)
            answer[i] = answer[i-1]+answer[i-2];
        return answer;
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
            System.out.print(f.solution(n)[i] + " ");
    }
}
