package 완전탐색.리모컨_1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String nStr = br.readLine();
        int n = Integer.parseInt(nStr);
        int m = Integer.parseInt(br.readLine());

        int answer = Math.abs(n-100);

        boolean[] broken = new boolean[10];
        if (m != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < m; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        for (int i = 0; i <= 999999; i++) {
            String num = String.valueOf(i);
            int len = num.length();

            boolean isBreak = false;
            for (int j = 0; j < len; j++) {
                if (broken[num.charAt(j) - '0']) {
                    isBreak = true;
                    break;
                }
            }

            if (!isBreak) {
                answer = Math.min(answer, Math.abs(n-i) + len);
            }
        }
        System.out.println(answer);
    }
}
