import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, max, min;
    static int[] nums, operators;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        StringTokenizer input = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input.nextToken());
        }

        // 덧셈, 뺄셈, 곱셈, 나눗셈
        operators = new int[4];
        input = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(input.nextToken());
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        DFS(1, nums[0]);

        sb.append(max).append("\n").append(min);
        System.out.println(sb);
    }

    private static void DFS(int count, int result) {
        if (count == n) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operators[i] == 0) continue;
            operators[i]--;
            int resultTemp = calculate(result, i, nums[count]);
            DFS(count + 1, resultTemp);
            operators[i]++;
        }
    }

    private static int calculate(int operand1, int operatorIndex, int operand2) {
        switch (operatorIndex) {
            case 0:
                return operand1 + operand2;
            case 1:
                return operand1 - operand2;
            case 2:
                return operand1 * operand2;
            case 3:
                return operand1 / operand2;
        }
        return -1;
    }
}
