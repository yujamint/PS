package section8.동전교환;

import java.util.*;

public class Main {
    static int n,m, answer= Integer.MAX_VALUE, sum=0;
    static Integer[] tokens;

    public void DFS(int L, int sum){
        if(sum > m) return;
        if(L>=answer) return;
        if(sum == m) {
            answer = Math.min(answer,L);
            return;
        }
        else {
            for(int i=0; i<n; i++){
                DFS(L + 1, sum+tokens[i]);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        tokens = new Integer[n];
        for(int i=0; i<n; i++)
            tokens[i] = sc.nextInt();
        Arrays.sort(tokens, Collections.reverseOrder());
        m = sc.nextInt();
        T.DFS(0, sum);
        System.out.println(answer);
    }
}
