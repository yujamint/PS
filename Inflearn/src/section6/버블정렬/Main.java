package section6.버블정렬;

import java.util.Scanner;

public class Main {
    public int[] solution(int n, int[] arr){
        for(int i=n-1; i>0; i--){
            for(int j=0; j<i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
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
