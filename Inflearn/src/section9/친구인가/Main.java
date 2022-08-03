package section9.친구인가;

import java.util.Scanner;


public class Main {
    static int[] unf;

    public int Find(int v){
        if(v==unf[v]) return unf[v];
        else return unf[v] = Find(unf[v]);
    }

    public void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa] = fb;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n+1]; // 어떤 집합에 속해있는지 저장하는 배열
        for (int i=1; i<=n; i++) unf[i] = i; // unf 배열 초기화
        for (int i = 0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            T.Union(a,b);
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(T.Find(a) == T.Find(b)) System.out.println("YES");
        else System.out.println("NO");
    }
}
