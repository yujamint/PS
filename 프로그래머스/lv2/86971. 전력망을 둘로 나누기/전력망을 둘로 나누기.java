import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int count, answer = Integer.MAX_VALUE;
    static boolean[][] ch, selected;

    public int solution(int n, int[][] wires) {
        List<List<Integer>> list = new ArrayList<>();
        selected = new boolean[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            list.get(wire[0]).add(wire[1]);
            list.get(wire[1]).add(wire[0]);
        }

        int start = 0;
        for (int i = 1; i <= n; i++) {
            if (list.get(i).size() > 1) {
                start = i;
                break;
            }
        }

        for (int v1 = 1; v1 <= n; v1++) {
            List<Integer> li = list.get(v1);
            for (int v2 : li) {
                if (selected[v2][v1]) continue;
                selected[v1][v2] = true;
                selected[v2][v1] = true;
                count = 0;
                ch = new boolean[n + 1][n + 1];
                ch[v1][v2] = true;
                ch[v2][v1] = true;
                DFS(list, start);
                int temp = Math.abs(n - 2 * (count + 1));
                answer = Math.min(temp, answer);
            }
        }

        return answer;
    }

    public void DFS(List<List<Integer>> list, int from) {
        List<Integer> li = list.get(from);

        for (int to : li) {
            if (!ch[from][to]) {
                ch[to][from] = true;
                ch[from][to] = true;
                count++;
                DFS(list, to);
            }
        }
    }
}
