package section9.Dijkstra;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    int vtx;
    int cost;
    public Edge(int vtx, int cost){
        this.vtx = vtx;
        this.cost = cost;
    }

    public int compareTo(Edge o){ // pQ에서 비용이 작은 간선부터 꺼내기 위해 비용 기준 오름차순 정렬
        return this.cost - o.cost;
    }
}

public class Main {
    static int n,m;
    static int[] dis;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    public void solution(int start){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(start, 0)); // 1번 정점 추가(출발점이기 때문에 cost는 0이다.)
        dis[start] = 0; // 1(시작점)에서 1(시작점)까지 가는 최소비용은 0이다.
        while(!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int now = tmp.vtx; // 뽑은 정점
            int nowCost = tmp.cost; // 1부터 뽑은 정점까지의 비용
            if(dis[now] < nowCost) continue; // 뽑은 정점까지의 비용이 기존에 찾은 비용보다 높다면 확인할 필요 없다.
            for (Edge ob : graph.get(now)) {// 뽑은 정점(now)과 연결된 간선들을 모두 확인한다.
                if(dis[ob.vtx] > nowCost + ob.cost) { // now에서 연결된 간선으로 가는 비용이 기존의 비용보다 작다면
                    dis[ob.vtx] = nowCost + ob.cost; // 비용을 더 작은 값으로 갱신해준다.
                    pQ.offer(new Edge(ob.vtx, nowCost + ob.cost)); // 더 작은 값을 넣었기 때문에 이 정점에서 뻗어나가며 더 작은 값을 찾기 위해 pQ에 추가
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        dis = new int[n+1]; // 1번 정점부터 n번 정점까지의 최소비용을 표현하기 위해 크기를 n+1로 지정한다.(0번 인덱스 사용 X)

        for (int i=0; i<=n; i++) graph.add(new ArrayList<Edge>()); // i번 정점과 연결된 간선을 표현하기 위한 ArrayList

        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b,c)); // 입력받은 간선 정보 ArrayList에 추가
        }

        for (int i=1; i<=n; i++) dis[i] = Integer.MAX_VALUE; // 초기값은 모두 최대값으로 갱신한다.

        T.solution(1); // 1번 정점에서의 최소거리를 찾기 위해 1번 정점부터 시작

        for (int i = 2; i<=n; i++){
            if(dis[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
            else System.out.println(i + " : impossible"); // 여전히 dis[i] = Integer.MAX_VALUE라면 i 정점으로 갈 수 있는 간선이 존재하지 않는다는 뜻
        }
    }
}
