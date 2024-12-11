import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Thing {
    int w;
    int v;

    public Thing(int w, int v) {
        this.w = w;
        this.v = v;
    }
}

public class Main {

    static int[][] dp;
    // dp(n개의 물건, 사용할 수 있는 배낭 공간) = 만족도 최대값
    static List<Thing> things = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            int c = 1;
            while (true) {
                if (count >= c) {
                    things.add(new Thing(weight * c, value * c));
                    count -= c;
                    c *= 2;
                }
                else break;
            }
            if (count > 0) {
                things.add(new Thing(weight * count, value * count));
            }
        }

        dp = new int[things.size() + 1][m + 1];


        for (int i = 1; i <= things.size(); i++) {
            Thing thing = things.get(i - 1);
            for (int k = 0; k <= m; k++) {
                if (k < thing.w) dp[i][k] = dp[i - 1][k];
                else dp[i][k] = Math.max(dp[i - 1][k], dp[i - 1][k - thing.w] + thing.v);
            }
        }
        System.out.println(dp[things.size()][m]);
    }
}
