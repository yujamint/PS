import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        Queue<Integer> queue = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();

        int order = 0;

        while (order < n) {
            for (int i = 0; i < n; i++) {
                progresses[i] += speeds[i];

                if (progresses[i] >= 100) {
                    queue.offer(i);
                    progresses[i] = Integer.MIN_VALUE;
                }
            }

            int cnt = 0;
            while (!queue.isEmpty() && queue.peek() == order) {
                queue.poll();
                order++;
                cnt++;
            }

            if (cnt != 0) {
                list.add(cnt);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}