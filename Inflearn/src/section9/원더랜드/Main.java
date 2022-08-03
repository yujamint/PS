package section9.원더랜드;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    int v1;
    int v2;
    int cost;
    public Edge(int v1, int v2, int cost){
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    public int compareTo(Edge o){
        return this.cost - o.cost;
    }
}

public class Main {
    static int[] unf;

    public int Find(int v) {
        if(v == unf[v]) return unf[v];
        else return unf[v] = Find(unf[v]);
    }

    public void Union(int v1, int v2){
        int fv1 = Find(v1);
        int fv2 = Find(v2);
        if (fv1 != fv2) unf[fv1] = fv2;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(); // 도시의 개수
        int e = sc.nextInt(); // 도로의 개수
        unf = new int[v+1];
        ArrayList<Edge> arr = new ArrayList<>();
        for (int i=1; i<=v; i++) unf[i] = i;
        for (int i=0; i<e; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            arr.add(new Edge(v1, v2, cost));
        }
        Collections.sort(arr);

        int answer = 0, cnt = 0;
        for (Edge ob : arr) {
            int fv1 = T.Find(ob.v1);
            int fv2 = T.Find(ob.v2);
            if(fv1 != fv2) {
                T.Union(ob.v1, ob.v2);
                answer += ob.cost;
                cnt++;
            }
            if (cnt == v-1) break;
        }
        System.out.println(answer);
    }
}
