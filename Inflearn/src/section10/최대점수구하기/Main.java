package section10.최대점수구하기;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dy = new int[m+1]; // i분에 얻을 수 있는 최대 점수
        for (int i=0; i<n; i++){
            int ps = sc.nextInt();
            int pt = sc.nextInt();
            for (int j = m; j>=pt; j--){
                dy[j] = Math.max(dy[j], dy[j-pt] + ps);
            }
        }
        System.out.println(dy[m]);
    }
}
