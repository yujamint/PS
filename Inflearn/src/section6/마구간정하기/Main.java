package section6.마구간정하기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public int distance(int[] arr, int n, int dist){
        int ep = 0, cnt = 1;
        for(int i=0; i<n; i++) {
            if((arr[i] - arr[ep]) >= dist) {
                ep = i;
                cnt++;
            }
        }
        return cnt;
    }

    public int solution(int n, int c, int[] arr){
        int answer = 0;
        Arrays.sort(arr);
        int lt = arr[1] - arr[0]; // 1로 설정해도 무방
        int rt = arr[n-1]; // 거리이기 때문에 arr[n-1] - arr[0]으로 하는 게 정확하지만, 이진탐색이기 때문에 arr[n-1]로 설정해도 무방

        while(lt <= rt){
            int mid = (lt+rt) / 2;
            int dist = distance(arr, n, mid);
            if(dist >= c) {
                answer = mid;
                lt = mid+1;
            }
            else rt = mid-1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int c =sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        System.out.println(m.solution(n,c,arr));
    }
}
