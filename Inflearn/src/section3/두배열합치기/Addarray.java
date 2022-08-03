package section3.두배열합치기;

import java.util.ArrayList;
//import java.util.Collections; 첫 번쨰 풀이에 사용
import java.util.Scanner;

public class Addarray {
    public ArrayList<Integer> solution(int n, int[] arr1, int m, int[] arr2){
        ArrayList<Integer> answer = new ArrayList<Integer>(n+m);
        int pa = 0, pb = 0;
        while(pa<n && pb<m){
            if(arr1[pa] < arr2[pb]) answer.add(arr1[pa++]);
            else answer.add(arr2[pb++]);
        }
        if(pa==n)
            for(int i=pb; i<m; i++)
                answer.add(arr2[i]);
        else
            for(int i=pa; i<n; i++)
                answer.add(arr1[i]);

        return answer;
    }

    public static void main(String[] args) {
        Addarray a = new Addarray();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i=0; i<n; i++)
            arr1[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i=0; i<m; i++)
            arr2[i] = sc.nextInt();

        for(int num : a.solution(n, arr1, m, arr2))
            System.out.print(num + " ");
    }
}
