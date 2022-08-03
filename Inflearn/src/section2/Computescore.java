package section2;

import java.util.Scanner;

public class Computescore {
    public int solution(int n, int[] ch){
        int answer = 0;
        int cnt=0;
        for(int i=0; i<n; i++){
            if(ch[i]==1) {
                cnt++;
                answer+=cnt;
            }
            else cnt=0;
        }
        return answer;
    }

    public static void main(String[] args) {
        Computescore c = new Computescore();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ch = new int[n];
        for(int i=0; i<n; i++)
            ch[i] = sc.nextInt();
        System.out.println(c.solution(n, ch));
    }
}
