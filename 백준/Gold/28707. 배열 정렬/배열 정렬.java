import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static class Swap {
        int x;
        int y;
        int cost;

        public Swap(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static class Pair implements Comparable<Pair> {
        int[] arr;
        int cost;

        public Pair(int[] arr, int cost) {
            this.arr = arr;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair o) {
            return this.cost - o.cost;
        }
    }

    static int n, m;
    static int[] arr;
    static List<Swap> list = new ArrayList<>();
    static Set<Long> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Swap(x - 1, y - 1, c));
        }
        System.out.println(dijkstra(arr));
    }

    private static int dijkstra(int[] arr) {
        Queue<Pair> queue = new PriorityQueue<>();
        queue.offer(new Pair(arr, 0));
        while (!queue.isEmpty()) {
            Pair pair;
            long key;
            do {
                pair = queue.poll();
                key = convertToLong(pair.arr);
            } while (!queue.isEmpty() && visited.contains(key));
            if (visited.contains(key)) break;
            visited.add(key);

            if (isDescendingOrder(pair.arr)) {
                return pair.cost;
            }

            for (int i = 0; i < m; i++) {

                Swap swap = list.get(i);
                int from = swap.x, to = swap.y;

                int[] swapArr = swapArr(pair.arr, from, to);
                queue.offer(new Pair(swapArr, pair.cost + swap.cost));
            }
        }
        return -1;
    }

    private static long convertToLong(int[] arr) {
        long num = 0;
        for (int j : arr) {
            num *= 10;
            num += j;
        }
        return num;
    }

    private static int[] swapArr(int[] arr, int x, int y) {
        int[] newArr = new int[n];
        System.arraycopy(arr, 0, newArr, 0, n);
        int temp = newArr[x];
        newArr[x] = newArr[y];
        newArr[y] = temp;
        return newArr;
    }

    private static boolean isDescendingOrder(int[] arr) {
        int prev = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] < prev) {
                return false;
            }
            prev = arr[i];
        }
        return true;
    }

}
