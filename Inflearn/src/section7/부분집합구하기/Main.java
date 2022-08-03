package section7.부분집합구하기;

public class Main {
    static int n;
    static int[] ch;
    public void DFS(int L){
        if(L == n+1) { // 모든 원소들을 넣을지 말지 선택했고, 어떤 원소들을 넣었는지 출력
            for(int i=1; i<=n; i++){
                if(ch[i] == 1) System.out.print(i + " ");
            }
            System.out.println("");
        }
        else{
            ch[L] = 1; // 포함한다고 결정
            DFS(L+1); // 왼쪽으로 뻗어나갈 때(부분집합에 포함할 떄)
            ch[L] = 0; // 포함하지 않는다고 결정
            DFS(L+1); // 오른쪽으로 뻗어나갈 때(부분집합에 포함 X)
        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        n=3;
        ch = new int[n+1];
        T.DFS(1);
    }
}
