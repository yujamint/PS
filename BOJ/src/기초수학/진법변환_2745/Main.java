package 기초수학.진법변환_2745;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String input = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);

            if (c >= 65) {
                answer += (c - 55) * Math.pow(b, input.length() - 1 - i);
            }
            else {
                answer += (c - '0') * Math.pow(b, input.length() - 1 - i);
            }
        }

        System.out.println(answer);
    }
}
