import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int lastOperatorIndex = 0;
        char lastOperator = '+';
        int result = 0;
        for (int i = 0; i <= str.length(); i++) {
            if (i != str.length() && str.charAt(i) != '+' && str.charAt(i) != '-') continue;

            int operand = Integer.parseInt(str.substring(lastOperatorIndex, i));
            lastOperatorIndex = i + 1;

            if (lastOperator == '-') {
                result -= operand;
                continue;
            }
            if (lastOperator == '+') {
                result += operand;
                if (i < str.length()) lastOperator = str.charAt(i);
            }
        }
        System.out.println(result);
    }
}
