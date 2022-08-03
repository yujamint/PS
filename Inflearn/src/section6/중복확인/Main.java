package section6.중복확인;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public char solution(int n, int[] arr){
        for(int i=1; i<n; i++){
            int key = arr[i];
            int j;
            for(j=i-1; j>=0; j--){
                if(arr[j] == key) return 'D';
                else if(arr[j] > key) arr[j+1] = arr[j];
                else break;
            }
            arr[j+1] = key;
        }
        return 'U';
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        System.out.println(m.solution(n,arr));
    }
}
