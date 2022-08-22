package DP.합분해_2225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long dividor = 1_000_000_000;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dy = new int[k+1][n + 1];

        for (int i = 0; i <= n; i++) {
            dy[1][i] = 1;
        }
        for (int i = 0; i <= k; i++) {
            dy[i][0] = 1;
        }

        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                for (int s = 0; s <= j; s++) {
                    dy[i][j] += dy[i - 1][j - s] % dividor;
                }
            }
        }

//        for (int i = 2; i <= k; i++) {
//            for (int j = 1; j <= n; j++) {
//                dy[i][j] = dy[i - 1][j] + dy[i][j - 1];
//            }
//        }

        System.out.println(dy[k][n]%dividor);
    }
}
