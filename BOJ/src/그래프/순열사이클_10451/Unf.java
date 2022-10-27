package 그래프.순열사이클_10451;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Unf {
    static int cycle;
    static int[] map, unf;

    public static int find(int x) {
        if (x == unf[x]) return x;
        else return unf[x] = find(unf[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) cycle++;
        else unf[x] = unf[y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            cycle = 0;
            int n = Integer.parseInt(br.readLine());

            map = new int[n + 1];
            unf = new int[n + 1];
            for (int i = 1; i <= n; i++) unf[i] = i;

            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 1; i <= n; i++) {
                map[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                union(i, map[i]);
            }

            System.out.println(cycle);
        }
    }
}
