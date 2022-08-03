package section4.K번째큰수;


import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public int solution(int n, int k, int[] arr){
        int answer=-1;
        TreeSet<Integer> set = new TreeSet<Integer>(Collections.reverseOrder());
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int s=j+1; s<n; s++){
                    set.add(arr[i]+arr[j]+arr[s]);
                }
            }
        }
        int cnt = 0;
        for(int x : set){
            cnt++;
            if(cnt==k) return x;
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
