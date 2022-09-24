package 기초수학.진법변환2_11005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder("");

        int result = n;
        while (true) {
            if (result <= 0) break;

            int temp = result % b;

            if (temp >= 10) sb.append((char)(55 + temp));
            else sb.append(temp);

            result /= b;
        }
        System.out.println(sb.reverse().toString());
    }
}
