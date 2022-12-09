package etc.팰린드롬_10174;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int test = 0; test < n; test++) {
            String input = br.readLine();
            input = input.toUpperCase(Locale.ROOT);

            String isPalindrome = "Yes";
            for (int i = 0; i < input.length() / 2; i++) {
                if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                    isPalindrome = "No";
                    break;
                }
            }

            sb.append(isPalindrome).append('\n');
        }

        System.out.println(sb);
    }
}
