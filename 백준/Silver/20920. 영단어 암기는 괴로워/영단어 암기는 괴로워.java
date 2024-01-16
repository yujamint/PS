import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(input.nextToken());
        int M = Integer.parseInt(input.nextToken());
        Map<String, Integer> countOfWord = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) continue;
            countOfWord.put(word, countOfWord.getOrDefault(word, 0) + 1);
        }

        Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (countOfWord.get(o1).equals(countOfWord.get(o2))) {
                    if (o1.length() == o2.length()) {
                        return o1.compareTo(o2);
                    }
                    return o2.length() - o1.length();
                }
                return countOfWord.get(o2) - countOfWord.get(o1);
            }
        });
        for (String word : countOfWord.keySet()) {
            queue.offer(word);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) sb.append(queue.poll()).append("\n");
        System.out.println(sb);
    }
}
