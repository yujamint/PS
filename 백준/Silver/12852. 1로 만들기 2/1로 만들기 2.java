import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Node[] dp = new Node[1_000_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        dp[0] = new Node(1_000_000, -1);
        dp[1] = new Node(0, 0);
        for (int i = 2; i <= n; i++) {
            int num1 = dp[i - 1].val + 1;
            int num2 = dp[i / 2].val + 1;
            int num3 = dp[i / 3].val + 1;

            if (i % 3 == 0 && num3 < num1) {
                if (i % 2 != 0 || (i % 2 == 0 && num3 < num2)) {
                    dp[i] = new Node(num3, i / 3);
                    continue;
                }
            }

            if (i % 2 == 0 && num2 < num1) {
                dp[i] = new Node(num2, i / 2);
                continue;
            }

            dp[i] = new Node(num1, i - 1);
        }

        sb.append(dp[n].val).append("\n");
        int pos = n;
        while (pos != 0) {
            Node node = dp[pos];
            sb.append(pos).append(" ");
            pos = node.prevVal;
        }
        System.out.println(sb);
    }
}

class Node {
    int val;
    int prevVal;

    public Node(int val, int prevVal) {
        this.val = val;
        this.prevVal = prevVal;
    }
}
