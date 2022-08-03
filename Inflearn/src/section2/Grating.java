package section2;

import java.util.Scanner;

public class Grating {
    public int solution(int n, int[][] grating){
        int answer = 0;
        for(int i=0; i<n; i++){
            int row = 0, column = 0;
            for(int j=0; j<n; j++){
                row += grating[i][j];
                column += grating[j][i];
            }

            int max = Math.max(row,column);
            if (answer < max) answer = max;
        }

        int diagonal1 = 0, diagonal2 = 0;
        for(int i=0; i<n; i++){
            diagonal1 += grating[i][i];
            diagonal2 += grating[i][n-i-1];
            int max = Math.max(diagonal1,diagonal2);
            if (answer < max) answer = max;
        }
        return answer;
    }

    public static void main(String[] args) {
        Grating g = new Grating();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grating = new int[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++)
                grating[i][j] = sc.nextInt();
        }
        System.out.println(g.solution(n, grating));
    }
}
