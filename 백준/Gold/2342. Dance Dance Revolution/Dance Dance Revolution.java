import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int c;
        int oppositeFoot;

        public Node(int c, int oppositeFoot) {
            this.c = c;
            this.oppositeFoot = oppositeFoot;
        }
    }

    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    static int len;
    static List<Integer> moves;
    static int[][] cost;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num;
        moves = new ArrayList<>();
        while ((num = Integer.parseInt(st.nextToken())) != 0) {
            moves.add(num);
        }
        initCost();
        len = moves.size();
        dp = new int[5][5][len];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(solve(0, 0, 0));

    }

    private static int solve(int left, int right, int cnt) {
        if (cnt == len) {
            return 0;
        }

        if (dp[left][right][cnt] != -1) {
            return dp[left][right][cnt];
        }

        int cur = moves.get(cnt);
        dp[left][right][cnt] = Math.min(
                solve(cur, right, cnt + 1) + cost[left][cur],
                solve(left, cur, cnt + 1) + cost[right][cur]
        );

        return dp[left][right][cnt];
    }

    private static void initCost() {
        cost = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0) {
                    cost[i][j] = 2;
                } else {
                    int diff = Math.abs(j - i);
                    if (diff == 0) {
                        cost[i][j] = 1;
                    } else if (diff == 2) {
                        cost[i][j] = 4;
                    } else {
                        cost[i][j] = 3;
                    }
                }
            }
        }
    }

}
