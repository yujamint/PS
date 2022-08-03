package section6.이분검색;

import java.util.Scanner;

public class Main {
    public int solution(int n, int k, int[] arr) {
        for(int i=1; i<n; i++){
            int key = arr[i];
            int j;
            for(j=i-1; j>=0; j--){
                if(arr[j] > key) arr[j+1] = arr[j];
                else break;
            }
            arr[j+1] = key;
        }

        int low = 0, high = n-1;
        while(low<=high) {
            int mid = (low + high) / 2;
            if(arr[mid] == k) return mid+1;
            else if(arr[mid] < k) low = mid+1;
            else high=mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        System.out.println(m.solution(n,k,arr));
    }
}
