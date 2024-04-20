import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static class Node {
        int cur;
        int left;
        int right;

        public Node(int cur, int left, int right) {
            this.cur = cur;
            this.left = left;
            this.right = right;
        }
    }

    static Node[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new Node[n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            int cur = input.charAt(0) - 65;
            int left = input.charAt(2) == '.' ? -1 : input.charAt(2) - 65;
            int right = input.charAt(4) == '.' ? -1 : input.charAt(4) - 65;

            arr[cur] = new Node(cur, left, right);
        }

        preOrder(0);
        sb.append('\n');
        inOrder(0);
        sb.append('\n');
        postOrder(0);
        System.out.println(sb);
    }

    private static void postOrder(int root) {
        Node node = arr[root];

        if (node.left != -1) postOrder(node.left);
        if (node.right != -1) postOrder(node.right);
        sb.append((char) (root + 65));
    }

    private static void inOrder(int root) {
        Node node = arr[root];

        if (node.left != -1) inOrder(node.left);
        sb.append((char) (root + 65));
        if (node.right != -1) inOrder(node.right);
    }

    private static void preOrder(int root) {
        Node node = arr[root];

        sb.append((char) (root + 65));
        if (node.left != -1) preOrder(node.left);
        if (node.right != -1) preOrder(node.right);
    }
}
