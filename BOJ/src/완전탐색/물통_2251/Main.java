package 완전탐색.물통_2251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int[] limit;
    static boolean[][] check;
    static Set<Integer> answer;

    public static void DFS(int a, int b, int c) {
        if (check[a][b]) return;
        if (a == 0) {
            answer.add(c);
        }
        check[a][b] = true;

        if (a + b > limit[1]) { // A -> B
            DFS(a - (limit[1] - b), limit[1], c);
        } else DFS(0, a + b, c);

        if (a + b > limit[0]) { // B -> A
            DFS(limit[0], b - (limit[0] - a), c);
        } else DFS(a + b, 0, c);

        if (a + c > limit[0]) { // C -> A
            DFS(limit[0], b, c - (limit[0] - a));
        } else DFS(a + c, b, 0);

        if (b + c > limit[1]) { // C -> B
            DFS(a, limit[1], c - (limit[1] - b));
        } else DFS(a, b + c, 0);

        DFS(0, b, a + c); // A -> C
        DFS(a, 0, b + c); // B -> C

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        limit = new int[3];
        check = new boolean[201][201];
        answer = new TreeSet<>();

        for (int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0, limit[2]);

        for (int num : answer) {
            System.out.print(num + " ");
        }
    }
}
