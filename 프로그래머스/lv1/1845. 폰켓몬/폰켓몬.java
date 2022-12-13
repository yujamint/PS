import java.util.HashMap;

class Solution {
public int solution(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        int n = nums.length / 2;

        return Math.min(n, hm.size());
    }
}