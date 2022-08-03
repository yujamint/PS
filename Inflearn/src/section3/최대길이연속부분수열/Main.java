package section3.최대길이연속부분수열;

import java.util.Scanner;

public class Main {
    public int solution(int n, int k, int[] arr){
        int answer = 0;
        int lt=0, cnt=0;
        for(int rt=0; rt<n; rt++){
            if(arr[rt]==0) {
                if(cnt < k) cnt++;
                else if(cnt==k) {
                    while(arr[lt]!=0) lt++;
                    lt++;
                }
            }
            answer = Math.max(answer,rt-lt+1);
        }
        return answer;

    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        System.out.println(m.solution(n, k, arr));
    }
}
