import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
            if (o.num == this.num) {
                return this.idx - o.idx;
            }
            return o.num - this.num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Node> list1 = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list1.add(new Node(i, Integer.parseInt(st.nextToken())));
        }
        int m = Integer.parseInt(br.readLine());
        List<Node> list2 = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            list2.add(new Node(i, Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list1);
        Collections.sort(list2);

        List<Integer> answer = new ArrayList<>();
        int idx1 = -1, idx2 = -1;
        int pos1 = 0, pos2 = 0;
        while (pos1 < n && pos2 < m) {
            Node node1 = list1.get(pos1);
            Node node2 = list2.get(pos2);
            if (node1.idx < idx1) {
                pos1++;
                continue;
            }
            if (node2.idx < idx2) {
                pos2++;
                continue;
            }
            
            if (node1.num == node2.num) {
                answer.add(node1.num);
                idx1 = node1.idx;
                idx2 = node2.idx;
                pos1++;
                pos2++;
            }
            else if (node1.num > node2.num) {
                pos1++;
            }
            else {
                pos2++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append('\n');
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i)).append(' ');
        }
        System.out.println(sb);
    }

}
