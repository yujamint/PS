package 문자열처리.ROT13_11655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        for (char c : input.toCharArray()) {
            if ( (c >= 65 && c < 78) || (c >= 97 && c < 110) ) c += 13;
            else if ( (c >= 78 && c <= 90) || (c >= 110 && c <= 122) ) c -= 13;

            sb.append(c);
        }
        System.out.println(sb);
    }
}
