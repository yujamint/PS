package 그래프.트리의부모찾기_11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] parent;
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();

    public static void DFS(int start) {
        for (int x : map.get(start)) {
            if (parent[x] != 0) continue;

            parent[x] = start;
            DFS(x);
        }
    }

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        parent[start] = start;

        for (int x : map.get(start)) {
            queue.offer(x);

            parent[x] = start;
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int x : map.get(cur)) {
                if (parent[x] != 0) continue;

                queue.offer(x);
                parent[x] = cur;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
            map.get(b).add(a);
        }

        parent[1] = 1;
        DFS(1);

        for (int i = 2; i <= n; i++) {
            System.out.print(parent[i] + " ");
        }
    }
}
