package 큐.큐_10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] strs = br.readLine().split(" ");

            String command = strs[0];

            switch (command) {
                case "push":
                    queue.offer(Integer.parseInt(strs[1]));
                    break;
                case "pop":
                    sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
                    break;
                case "back":
                    for (int j = 0; j < queue.size()-1; j++) {
                        queue.offer(queue.poll());
                    }
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(queue.peek()).append("\n");
                        queue.offer(queue.poll());
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
