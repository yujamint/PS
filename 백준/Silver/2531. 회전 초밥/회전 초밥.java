import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int[] sushi;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int dishCount = Integer.parseInt(st.nextToken());
        int coupon = Integer.parseInt(st.nextToken());
        sushi = new int[2 * n - 1];

        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        for (int i = n; i < sushi.length; i++) {
            sushi[i] = sushi[i - n];
        }

        int lo = 0, hi = dishCount - 1;
        Map<Integer, Integer> countOfSushi = new HashMap<>();
        for (int i = lo; i <= hi; i++) {
            countOfSushi.put(sushi[i], countOfSushi.getOrDefault(sushi[i], 0) + 1);
        }
        int count = countOfSushi.containsKey(coupon) ? countOfSushi.keySet().size() : countOfSushi.keySet().size() + 1;
        max = Math.max(max, count);

        lo++;
        hi++;
        while (hi < sushi.length) {
            if (countOfSushi.get(sushi[lo - 1]) == 1) {
                countOfSushi.remove(sushi[lo - 1]);
            } else {
                countOfSushi.put(sushi[lo - 1], countOfSushi.get(sushi[lo - 1]) - 1);
            }
            countOfSushi.put(sushi[hi], countOfSushi.getOrDefault(sushi[hi], 0) + 1);

            count = countOfSushi.containsKey(coupon) ? countOfSushi.keySet().size() : countOfSushi.keySet().size() + 1;
            max = Math.max(max, count);

            lo++;
            hi++;
        }

        System.out.println(max);
    }
}
