package etc.팰린드롬수_1259;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        while (!(input = br.readLine()).equals("0")) {
            String isPalindrome = "yes";
            for (int i = 0; i < input.length() / 2; i++) {
                if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                    isPalindrome = "no";
                    break;
                }
            }
            sb.append(isPalindrome).append('\n');
        }

        System.out.println(sb);
    }
}
