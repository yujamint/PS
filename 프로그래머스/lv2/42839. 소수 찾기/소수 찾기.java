import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String numbers) {
        Set<Integer> set = new HashSet<>();
        
        DFS("", numbers, set);

        int count = 0;
        while (set.iterator().hasNext()) {
            int num = set.iterator().next();
            set.remove(num);
            if (num == 2) {
                count++;
            }
            if (num % 2 != 0 && isPrime(num)) {
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int number) {
        if (number == 0 || number == 1) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public void DFS(String prefix, String str, Set<Integer> set) {
        int len = str.length();
        if (!prefix.equals("")) {
            set.add(Integer.parseInt(prefix));
        }
        for (int i = 0; i < len; i++) {
            DFS(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, len), set);
        }
    }
}