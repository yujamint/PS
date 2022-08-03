package section6.선택정렬;

import java.util.Scanner;

public class Main {
    public int[] solution(int n, int[] arr){
        int index=0;
        for(int i=0; i<n-1; i++){
            int min = Integer.MAX_VALUE;
            for(int j=i; j<n; j++){
                if(arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[i];
            arr[i] = min;
        }
        return arr;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        for(int i : m.solution(n,arr))
            System.out.print(i + " ");
    }
}
