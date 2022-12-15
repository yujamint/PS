class Solution {
    public int solution(int left, int right) {
        int sum = 0;
        
        for (int i = left; i <= right; i++) {
            if (i % Math.sqrt(i) == 0) {
                sum -= i;
            } else {
                sum += i;
            }
        }
        
        return sum;
    }
}