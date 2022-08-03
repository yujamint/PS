package section3.최대매출;

import java.util.Scanner;

public class MaximumSales {
    public int solution(int n, int k, int[] arr){
        int answer, sum=0;
        for (int i=0; i<k; i++) sum+=arr[i];
        answer = sum;

        for(int i=k; i<n; i++){
            sum+=(arr[i] - arr[i-k]);
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    public static void main(String[] args) {
        MaximumSales m = new MaximumSales();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        System.out.println(m.solution(n, k, arr));
    }
}
