import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            count = 0;
            String input = br.readLine();
            sb.append(isPalindrome(input, 0)).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static int isPalindrome(String input, int len) {
        count++;
        if (len >= input.length() / 2) return 1;
        if (input.charAt(len) == input.charAt(input.length() - len -1)) return isPalindrome(input, len + 1);
        return 0;
    }
}
