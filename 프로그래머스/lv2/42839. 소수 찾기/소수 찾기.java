class Solution {
    private static final int MAX = 9_999_999;
    static int n, cnt = 0;
    static int[] arr;
    static boolean[] numCh;
    static boolean[] ch = new boolean[MAX + 1];
    static boolean[] prime = new boolean[MAX + 1];

    public int solution(String numbers) {
        n = numbers.length();
        arr = new int[n];
        numCh = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = numbers.charAt(i) - '0';
        }

        makePrime();

        DFS(0, "");

        return cnt;
    }

    public void DFS(int L, String numStr) {
        if (L == n) {
            if (!numStr.isEmpty()) {
                int num = Integer.parseInt(numStr);

                if (!ch[num] && !prime[num]) {
                    System.out.println(num);
                    ch[num] = true;
                    cnt++;
                }
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                if (numCh[i]) continue;
                
                numCh[i] = true;
                DFS(L + 1, numStr + arr[i]);
                DFS(L + 1, numStr);
                numCh[i] = false;
            }
        }
    }

    public void makePrime() {
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(MAX); i++) {

            if (prime[i]) {
                continue;
            }

            for (int j = i * i; j < MAX; j += i) {
                prime[j] = true;
            }
        }
    }
}