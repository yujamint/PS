package 완전탐색.날짜계산_1476;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean flag = true;

        int n = 0;
        while(flag) {
            n++;
            if((n-E) % 15 == 0 && (n-S) % 28 == 0 && (n-M) % 19 == 0) {
                flag = false;
            }
        }
        System.out.println(n);
    }
}
