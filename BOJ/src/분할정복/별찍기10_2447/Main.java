package 분할정복.별찍기10_2447;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, cnt = 1;
    static char[][] stars;
    static StringBuilder sb;

    public static void star(int N) {
        if (N > n) {
            return;
        }

        int cnt = n / N;

        for (int row = 0; row < cnt; row++) {
            for (int col = 0; col < cnt; col++) {
                for (int i = N / 3 + 1; i <= N / 3 * 2; i++) {
                    for (int j = N / 3 + 1; j <= N / 3 * 2; j++) {
                        stars[i + row * N][j + col * N] = ' ';
                    }
                }
            }
        }

        star(N * 3);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        stars = new char[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                stars[i][j] = '*';
            }
        }

        star(3);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(stars[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
