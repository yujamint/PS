package section2;

import java.util.Scanner;

public class Peaks {
    public int solution(int n, int[][] arr){
        int answer = 0;
        int[][] map = new int[n+2][n+2];
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                map[i+1][j+1] = arr[i][j];

        for (int i=1; i<=n; i++)
            for (int j = 1; j <= n; j++) {
                if (map[i][j] > map[i - 1][j] && map[i][j] > map[i + 1][j] && map[i][j] > map[i][j - 1] && map[i][j] > map[i][j + 1])
                    answer++;
            }

        return answer;
    }

    public static void main(String[] args) {
        Peaks p = new Peaks();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                arr[i][j] = sc.nextInt();
        System.out.println(p.solution(n, arr));
    }
}
