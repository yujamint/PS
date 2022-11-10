package 그래프.트리의지름_1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Edge {
    int dest;
    int weight;

    public Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}

public class Main {
    static int n, max = Integer.MIN_VALUE;
    static boolean[] ch;
    static List<List<Edge>> graph;

    public static void DFS(int x, int sum) {
        max = Math.max(sum, max);

        ch[x] = true;
        for (Edge edge : graph.get(x)) {
            int nx = edge.dest;
            int w = edge.weight;

            if (ch[nx]) {
                continue;
            }

            DFS(nx, sum + w);
        }
        ch[x] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        ch = new boolean[n+1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, w));
            graph.get(b).add(new Edge(a, w));
        }

        for (int i = 1; i <= n; i++) {
            DFS(i, 0);
        }

        System.out.println(max);
    }
}
