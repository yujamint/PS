package 완전탐색.소수경로_1963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] prime, visited;

    public static void BFS(int before, int after) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(before);

        visited = new boolean[10000];
        visited[before] = true;

        int L = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int cur = queue.poll();
                if (cur == after) {
                    System.out.println(L);
                    return;
                }

                String strCur = Integer.toString(cur);
                int four = strCur.charAt(0) - '0';
                int three = strCur.charAt(1) - '0';
                int two = strCur.charAt(2) - '0';
                int one = strCur.charAt(3) - '0';

                for (int j = 1; j <= 9; j++) {
                    if (j != four) {
                        int temp = cur - (four * 1000) + (j * 1000);
                        if (prime[temp] && !visited[temp]) {
                            queue.offer(temp);
                            visited[temp] = true;
                        }
                    }
                }
                for (int j = 0; j <= 9; j++) {
                    if (j != three) {
                        int temp = cur - (three * 100) + (j * 100);
                        if (prime[temp] && !visited[temp]) {
                            queue.offer(temp);
                            visited[temp] = true;
                        }
                    }
                }
                for (int j = 0; j <= 9; j++) {
                    if (j != two) {
                        int temp = cur - (two * 10) + (j * 10);
                        if (prime[temp] && !visited[temp]) {
                            queue.offer(temp);
                            visited[temp] = true;
                        }
                    }
                }
                for (int j = 1; j <= 9; j++) {
                    if (j != one) {
                        int temp = cur - one + j;
                        if (prime[temp] && !visited[temp]) {
                            queue.offer(temp);
                            visited[temp] = true;
                        }
                    }
                }
            }
            L++;
        }
        System.out.println("Impossible");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        prime = new boolean[10000];

        for (int i=0; i<=9999; i++) prime[i] = true;

        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i <= 9999; i ++) {
            if (!prime[i]) continue;
            for (int j = 2 * i; j <= 9999; j += i) prime[j] = false;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            BFS(before, after);
        }
    }
}
