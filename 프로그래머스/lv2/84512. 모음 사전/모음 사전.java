class Solution {
    static int cnt = 0;
    static boolean flag = false;
    static char[] arr = {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        DFS(word, "");
        
        return cnt-1;
    }

    public static void DFS(String word, String str) {
        if (flag) return;
        
        cnt++;
        
        if (str.equals(word)) {
            flag = true;
            return;
        }
        if (str.length() >= 5) {
            return;
        }
        for (char c : arr) {
            DFS(word, str + c);
        }
    }
}