package 정렬.카드_11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Long num = Long.parseLong(br.readLine());
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        Long answer = Long.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Map.Entry entry : hm.entrySet()) {
            Long key = (Long) entry.getKey();
            int value = (int) entry.getValue();

            if (value > max) {
                answer = key;
                max = value;
            }
            if (value == max) answer = Math.min(answer, key);
        }

        System.out.println(answer);
    }
}
