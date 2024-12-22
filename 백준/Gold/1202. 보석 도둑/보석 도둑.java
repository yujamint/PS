import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    1. 가치가 제일 큰 보석을 찾는다.
    2. 보석이 들어갈 수 있는 가방 중 제일 용량이 작은 곳에 넣는다.
    3. 1,2번 반복
     */

    static int n, k;
    static TreeMap<Integer, Integer> knapsack = new TreeMap<>();
    static Queue<Jewel> jewels = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels.offer(new Jewel(weight, value));
        }

        for (int i = 0; i < k; i++) {
            int size = Integer.parseInt(br.readLine());
            knapsack.put(size, knapsack.getOrDefault(size, 0) + 1);
        }

        long sum = 0;
        while (!jewels.isEmpty() && !knapsack.isEmpty()) {
            Jewel cur = jewels.poll();

            if (knapsack.lastKey() < cur.weight) {
                continue;
            }

            int key;
            if (knapsack.containsKey(cur.weight)) {
                key = cur.weight;
            } else {
                key = knapsack.higherKey(cur.weight);
            }

            sum += cur.value;
            knapsack.put(key, knapsack.get(key) - 1);
            if (knapsack.get(key) == 0) {
                knapsack.remove(key);
            }
        }

        System.out.println(sum);
    }
}

class Jewel implements Comparable<Jewel> {
    int weight;
    int value;

    public Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(Jewel o) {
        if (this.value == o.value) {
            return this.weight - o.weight;
        }
        return o.value - this.value;
    }
}
