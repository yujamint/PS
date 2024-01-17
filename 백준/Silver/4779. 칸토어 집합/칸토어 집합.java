import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            char[] chars = new char[(int) Math.pow(3, n)];
            Arrays.fill(chars, '-');
            recursion(chars, 0, chars.length);
            sb.append(chars).append("\n");
        }
        System.out.println(sb);
    }

    private static void recursion(char[] chars, int start, int end) {
        int length = end - start;
        if (length >= 3) {
            int removeStart = start + length / 3;
            int removeEnd = start + length / 3 * 2;
            for (int i = removeStart; i < removeEnd; i++) chars[i] = ' ';
            recursion(chars, start, removeStart);
            recursion(chars, removeEnd, end);
        }
    }
}
