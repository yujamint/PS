package section2.임시반장정하기;

import java.util.Scanner;

public class Classcaptain {
    public int solution(int n, int[][] arr){
        int answer = 0;
        int[][] students = new int[n][n];
        for (int i=0; i<n; i++){
            int cnt = 0;
            for (int j=0; j<5; j++){
                for( int k=0; k<n; k++)
                    if(arr[i][j] == arr[k][j] && k != i) {
                        students[i][k] = 1;
                    }
            }
        }
        int[] temp = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                temp[i] += students[i][j];
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
            if(max < temp[i]) {
                max = temp[i];
                answer = i+1;
            }
        return answer;
    }

    public static void main(String[] args) {
        Classcaptain p = new Classcaptain();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][5];
        for (int i=0; i<n; i++)
            for (int j=0; j<5; j++)
                arr[i][j] = sc.nextInt();
        System.out.println(p.solution(n, arr));
    }
}
