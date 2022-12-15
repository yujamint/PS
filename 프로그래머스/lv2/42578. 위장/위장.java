import java.util.HashMap;
import java.util.Arrays;

class Solution {
    static int n, answer = 0;
    
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hm = new HashMap<>();

        for (String[] cloth : clothes) {
            hm.put(cloth[1], hm.getOrDefault(cloth[1], 0) + 1);
        }
        
        n = hm.size();

        Integer[] values = hm.values().toArray(new Integer[n]);

        DFS(0, 1, values);
        
        answer -= 1;
        
        return answer;
    }
    
    public static void DFS(int L, int sum, Integer[] values) {
        if (L == n) {
            answer += sum;
        }
        else {
            DFS(L + 1, sum * values[L], values);
            DFS(L + 1, sum, values);
        }
    }
}