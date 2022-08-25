package DP.암호코드_2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int dividor = 1_000_000;
        String str = br.readLine();
        int n = str.length();

        String[] tokens = str.split("");
        String[] arr = new String[n + 1];
        arr[0] = "0";
        for (int i = 1; i <= n; i++) {
            arr[i] = tokens[i - 1];
        }

        int[] dy = new int[n + 1];
        dy[0] = 1;

        if (n >= 1) dy[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (Integer.parseInt(arr[i - 1] + arr[i]) == 0) {
                System.out.println(0);
                return;
            }
            dy[i] = dy[i - 1];
            if (i < n) {
                if (Integer.parseInt(arr[i]) != 0 && arr[i + 1].equals("0")) {
                    dy[i + 1] = dy[i - 1];
                    i++;
                    continue;
                }
            }
            if (Integer.parseInt(arr[i - 1] + arr[i]) <= 26) dy[i] = (dy[i] + dy[i - 2]) % dividor;
        }

        System.out.println(dy[n] % dividor);
    }
}
