package 기타자료구조.요세푸스문제_1158;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] answer = new int[n];
        int idx = 0;
        for (int i = 1; i<=n; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < k-1; i++) {
                queue.offer(queue.poll());
            }

            answer[idx++] = queue.poll();
        }

        sb.append('<');
        for (int i = 0; i < n - 1; i++) {
            sb.append(answer[i]).append(", ");
        }
        sb.append(answer[n-1]).append(">");

        System.out.println(sb);
    }
}
