package 완전탐색.숨바꼭질_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int a, b, answer = Integer.MAX_VALUE;
    static int[] ch;

    public static void BFS(int a) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        ch[a] = 1;
        int L = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int j = 0; j < len; j++) {
                int cur = queue.poll();
                for (int i = 0; i < 3; i++) {
                    int next;
                    if (i == 0) next = cur + 1;
                    else if (i == 1) next = cur - 1;
                    else next = cur * 2;

                    if (next == b) {
                        answer = L;
                        return;
                    }

                    if (next >= 0 && next < ch.length && ch[next] == 0) {
                        ch[next] = L;
                        queue.offer(next);
                    }
                }
            }
            L++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ch = new int[100_001];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        if(a==b) {
            System.out.println(0);
            return;
        }

        BFS(a);

        System.out.println(answer);
    }
}
