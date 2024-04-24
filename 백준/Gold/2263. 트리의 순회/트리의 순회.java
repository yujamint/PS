import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] inorder, postorder;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        inorder = new int[n];
        postorder = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, n, 1);
        System.out.println(sb);
    }

    private static void DFS(int start, int end, int level) {
        // rootIdx 찾아서 StringBuilder 추가
        if (end == start) {
            return;
        }
        int root = postorder[end - level];
        int inorderRootIdx = 0;
        for (int i = start; i < end; i++) {
            if (inorder[i] == root) {
                inorderRootIdx = i;
                break;
            }
        }
        sb.append(root).append(' ');

        // 왼쪽 subtree 범위로 재귀
        DFS(start, inorderRootIdx, level);
        // 오른쪽 subtree 범위로 재귀
        DFS(inorderRootIdx + 1, end, level + 1);
    }

}
