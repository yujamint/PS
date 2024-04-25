import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parent = new int[v + 1];
        Arrays.fill(parent, -1);

        List<Edge> graph = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.add(new Edge(a, b, c));
        }
        Collections.sort(graph);

        int count = 0;
        int mstWeight = 0;
        for (int i = 0; i < e; i++) {
            Edge minWeightEdge = graph.get(i);
            int from = minWeightEdge.from;
            int to = minWeightEdge.to;
            if (find(from) == find(to)) continue;
            union(from, to);
            count++;
            mstWeight += minWeightEdge.weight;

            if (count == v - 1) break;
        }
        System.out.println(mstWeight);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        parent[x] = y;
    }

    private static int find(int x) {
        if (parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }

}
