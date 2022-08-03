package section3.공통원소구하기;

import java.util.ArrayList;
// import java.util.Collections; 첫 번쨰 풀이 사용
import java.util.Arrays;
import java.util.Scanner;

public class Commonelement {
    public ArrayList<Integer> solution(int n, int[] arr1, int m, int[] arr2){
        ArrayList<Integer> answer = new ArrayList<Integer>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int pa = 0, pb = 0;
        while(pa<n && pb<m){
            if(arr1[pa] == arr2[pb]) {
                answer.add(arr1[pa++]);
                pb++;
            }
            else if(arr1[pa] < arr2[pb]) pa++;
            else pb++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Commonelement c = new Commonelement();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i=0; i<n; i++)
            arr1[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i=0; i<m; i++)
            arr2[i] = sc.nextInt();

        for(int num : c.solution(n, arr1, m, arr2))
            System.out.print(num + " ");
    }
}
