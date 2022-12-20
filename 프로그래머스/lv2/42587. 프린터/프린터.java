import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Document{
    int number;
    int priority;

    public Document(int number, int priority) {
        this.number = number;
        this.priority = priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int n = priorities.length;
        Queue<Document> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.offer(new Document(i, priorities[i]));
        }

        Arrays.sort(priorities);
        int order = 1;
        int maxPriority = priorities[n - 1];

        while (!queue.isEmpty()) {
            Document cur = queue.poll();

            if (cur.priority < maxPriority) {
                queue.offer(cur);
                continue;
            }

            if (cur.priority == maxPriority) {
                if (cur.number == location) {
                    return order;
                }
                order++;
                maxPriority = priorities[n - order];
            }
        }

        return 0;
    }
}