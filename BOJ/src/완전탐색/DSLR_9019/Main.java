package 완전탐색.DSLR_9019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Register {
    String history;
    int n;

    public Register(int n, String history) {
        this.n = n;
        this.history = history;
    }
}

public class Main {
    static boolean[] visited;

    public static void BFS(int a, int b) {
        Queue<Register> q = new LinkedList<>();

        q.offer(new Register(a, ""));
        visited[a] = true;

        while (!q.isEmpty()) {
            Register cur = q.poll();
            int n = cur.n;

            if (n == b) {
                System.out.println(cur.history);
                return;
            }

            int temp;

            // D : 2 * n % 10000
            temp = (2 * n) % 10000;
            if (!visited[temp]) {
                q.offer(new Register(temp, cur.history + "D"));
                visited[temp] = true;
            }
            // S : n - 1
            if (n == 0) {
                if (!visited[9999]) {
                    q.offer(new Register(9999, cur.history + "S"));
                    visited[9999] = true;
                }
            }
            else {
                if (!visited[n - 1]) {
                    q.offer(new Register(n - 1, cur.history + "S"));
                    visited[n - 1] = true;
                }
            }
            // L : 한 칸씩 왼쪽으로 ( 1234 -> 2341 )
            temp = (n % 1000) * 10 + (n / 1000);
            if (!visited[temp]) {
                q.offer(new Register(temp, cur.history + "L"));
                visited[temp] = true;
            }
            // R : 한 칸씩 오른쪽으로 ( 1234 -> 4123 )
            temp = (n % 10) * 1000 + (n / 10);
            if (!visited[temp]) {
                q.offer(new Register(temp, cur.history + "R"));
                visited[temp] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            visited = new boolean[10001];

            BFS(a,b);
        }
    }
}
