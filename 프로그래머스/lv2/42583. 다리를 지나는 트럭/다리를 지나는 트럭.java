import java.util.LinkedList;
import java.util.Queue;

class Truck {
    int weight;
    int progress;

    public Truck(int weight, int progress) {
        this.weight = weight;
        this.progress = progress;
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int crossed = 0;
        int sum = 0;

        Queue<Truck> bridge = new LinkedList<>();

        int idx = 0;
        while (crossed < truck_weights.length) {
            time++;

            for (Truck truck : bridge) {
                truck.progress += 1;
            }

            if (!bridge.isEmpty() && bridge.peek().progress > bridge_length) {
                sum -= bridge.poll().weight;
                crossed++;
            }

            if (bridge.size() >= bridge_length) {
                continue;
            }

            if (idx < truck_weights.length && sum + truck_weights[idx] <= weight) {
                bridge.offer(new Truck(truck_weights[idx], 1));
                sum += truck_weights[idx];
                idx++;
            }
        }

        return time;
    }
}