import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dp;
    static boolean[][] isPalindrome; 
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        n = input.length();
        dp = new int[n + 1];
        isPalindrome = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                checkPalindrome(input, i, j);
            }
        }

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (!isPalindrome[j + 1][i]) {
                    continue;
                }
                min = Math.min(min, dp[j] + 1);
            }
            dp[i] = min;
        }
        System.out.println(dp[n]);
    }

    private static void checkPalindrome(String str, int i, int j) {
        boolean res = true;
        int l = i - 1;
        int r = j - 1;
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) {
                res = false;
                break;
            }
        }
        isPalindrome[i][j] = res;
    }

}
