package section2;

import java.util.Scanner;

public class Getrank {
    public int[] solution(int n, int[] scores){
        int[] answer = new int[n];
        for (int i=0; i<n; i++) {
            int cnt = 1;
            for (int j=0; j<n; j++)
                if(scores[i] < scores[j]) cnt++;
            answer[i] = cnt;
        }
        return answer;
    }

    public static void main(String[] args) {
        Getrank g = new Getrank();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i=0; i<n; i++)
            scores[i] = sc.nextInt();
        for (int rank : g.solution(n, scores))
            System.out.print(rank + " ");
    }
}
