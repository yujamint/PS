package section10.동전교환;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n,m;
    static int[] dy;

    public int solution(int[] coin){
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for (int i=0; i<n; i++){
            int c = coin[i];
            for (int j=c; j<=m; j++) {
                dy[j] = Math.min(dy[j], dy[j-c] + 1);
            }
        }
        return dy[m];
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] coin = new int[n];
        for (int i=0; i<n; i++) coin[i] = sc.nextInt();
        m = sc.nextInt();
        dy = new int[m+1];
        System.out.println(T.solution(coin));
    }
}
