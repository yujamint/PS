import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int cur;
        List<Node> childNodes = new ArrayList<>();

        public Node(int cur) {
            this.cur = cur;
        }

        public void addChild(int node) {
            childNodes.add(new Node(node));
        }
    }

    static List<List<Integer>> graph = new ArrayList<>();
    static Node[] nodes;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        size = new int[n + 1];
        nodes = new Node[n + 1];
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        makeTree(r, -1);

        countSubtreeNodes(r);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int root = Integer.parseInt(br.readLine());
            sb.append(size[root]).append('\n');
        }
        System.out.println(sb);
    }

    private static void makeTree(int currentNode, int parent) {
        Node node = new Node(currentNode);
        nodes[currentNode] = node;
        for (int connectedNode : graph.get(currentNode)) {
            if (connectedNode == parent) continue;
            node.addChild(connectedNode);
            makeTree(connectedNode, currentNode);
        }
    }

    private static int countSubtreeNodes(int root) {
        size[root] = 1;
        for (Node childNode : nodes[root].childNodes) {
            size[root] += countSubtreeNodes(childNode.cur);
        }
        return size[root];
    }

}
