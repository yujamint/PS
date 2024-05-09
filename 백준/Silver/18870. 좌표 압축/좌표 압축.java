import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int idx;
        int num;

        public Node(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            return this.num - o.num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];
        Queue<Node> queue = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            queue.add(new Node(i, num));
        }
        Node prev = queue.poll();
        int comp = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (prev.num < cur.num) {
                answer[cur.idx] = ++comp;
            } else {
                answer[cur.idx] = comp;
            }
            prev = cur;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(' ');
        }
        System.out.println(sb);
    }

}
