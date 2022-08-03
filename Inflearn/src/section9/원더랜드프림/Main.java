package section9.원더랜드프림;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    int v;
    int cost;
    public Edge(int v, int cost){
        this.v = v;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[] ch = new int[v+1]; // 이미 트리에 들어가있는지 체크하기 위한 배열

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i=0; i<=v; i++) graph.add(new ArrayList<Edge>()); // 인접 리스트 생성

        for (int i=0; i<e; i++){ // 인접 리스트에 간선 추가
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(v1).add(new Edge(v2,cost));
            graph.get(v2).add(new Edge(v1,cost)); // 무방향 그래프이기 때문에 양 방향 모두 간선 넣어줘야된다.
        }

        int answer = 0;

        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1,0)); // 정점 1부터 시작(시작점이기 때문에 cost = 0)
        while (!pQ.isEmpty()){
            Edge tmp = pQ.poll(); // 가중치 가장 적은 간선 뽑기
            int nv = tmp.v;
            if(ch[nv] == 0) { // 트리에 들어가있지 않은 정점이라면
                ch[nv] = 1; // 트리에 넣으면서 체크하고,
                answer += tmp.cost; // 가중치 합
                for (Edge ob : graph.get(nv)) { // 정점 tmp와 연결된 모든 정점 중에서
                    if(ch[ob.v]==0)pQ.offer(ob); // 이미 추가한 간선의 반대 방향을 pQ에 넣지 않기 위해 ch배열 체크
                                                 // ex) (1, 2, 12) 트리에 포함했는데 (2, 1, 12)를 또 pQ에 넣지 않기 위함
                }
            }
        }

        System.out.println(answer);
    }
}
