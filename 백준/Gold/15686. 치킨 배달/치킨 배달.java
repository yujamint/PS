import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final int EMPTY = 0;
    private static final int HOUSE = 1;
    private static final int CHICKEN = 2;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, min = Integer.MAX_VALUE;
    static Node[] nodes;
    static int[][] map;
    static List<Node> chickens = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nodes = new Node[m];
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == CHICKEN) {
                    chickens.add(new Node(i, j));
                }
            }
        }
        pickChickens(0, 0);
        System.out.println(min);
    }

    private static void pickChickens(int startIdx, int count) {
        if (count == m) {
            min = Math.min(min, calculateChickenDistance(nodes));
            return;
        }
        for (int i = startIdx; i < chickens.size(); i++) {
            Node cur = chickens.get(i);
            nodes[count] = cur;
            pickChickens(i + 1, count + 1);
        }
    }

    private static int calculateChickenDistance(Node[] nodes) {
        int distSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == HOUSE) {
                    int min = Integer.MAX_VALUE;
                    for (int k = 0; k < m; k++) {
                        Node cur = nodes[k];
                        int dist = Math.abs(cur.x - i) + Math.abs(cur.y - j);
                        min = Math.min(min, dist);
                    }
                    distSum += min;
                }
            }
        }
        return distSum;
    }

}
