package 그래프.숫자놀이_2145;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = "";
        while (!(str = br.readLine()).equals("0")) {

            while (str.length() != 1) {
                int temp = 0;
                for (int i = 0; i < str.length(); i++) {
                    temp += str.charAt(i) - '0';
                }
                str = String.valueOf(temp);
            }
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }
}
