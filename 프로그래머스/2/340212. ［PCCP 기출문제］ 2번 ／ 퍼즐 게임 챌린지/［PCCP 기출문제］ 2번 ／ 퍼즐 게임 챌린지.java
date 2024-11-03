class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int lo = 1, hi = 100_000;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            
            long time = calculateTotalTime(diffs, times, mid);
            if (time > limit) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
    
    private long calculateTotalTime(int[] diffs, int[] times, int level) {
        long sum = 0L;
        for (int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
            int time = times[i];
            
            if (diff <= level) sum += time;
            else {
                int prevTime = i == 0 ? 0 : times[i - 1];
                int solvingTime = (time + prevTime) * (diff - level) + time;
                sum += solvingTime;
            }
        }
        return sum;
    }
}