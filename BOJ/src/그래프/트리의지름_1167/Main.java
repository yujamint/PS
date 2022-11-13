package 그래프.트리의지름_1167;

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
    static int v, maxIdx=0, max = Integer.MIN_VALUE;
    static boolean[] ch;
    static List<List<Edge>> list;

    public static void DFS(int x, int sum) {
        if (sum > max) {
            max = sum;
            maxIdx = x;
        }

        for (Edge edge : list.get(x)) {
            int dest = edge.dest;
            int weight = edge.weight;

            if (ch[dest]) {
                continue;
            }

            ch[dest] = true;
            DFS(dest, sum + weight);
            ch[dest] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        v = Integer.parseInt(br.readLine());

        ch = new boolean[v + 1];
        list = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= v; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b;
            while ((b = Integer.parseInt(st.nextToken())) != - 1) {
                int w = Integer.parseInt(st.nextToken());
                list.get(a).add(new Edge(b, w));
            }
        }

        ch[1] = true;
        DFS(1, 0);
        ch[1] = false;


        ch[maxIdx] = true;
        DFS(maxIdx, 0);

        System.out.println(max);
    }
}
