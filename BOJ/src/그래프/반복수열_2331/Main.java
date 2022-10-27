package 그래프.반복수열_2331;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(n, 1);

        int prevNum = n;

        while (true) {
            int num = 0;
            while (prevNum > 0) {
                int mod = prevNum % 10;
                num = num + (int)Math.pow(mod, p);
                prevNum /= 10;
            }
            hm.put(num, hm.getOrDefault(num, 0) + 1);
            if (hm.get(num) >= 3) break;
            prevNum = num;
        }

        Collection<Integer> values = hm.values();
        ArrayList<Integer> list = new ArrayList<>(values);
        Collections.sort(list);

        int cnt = 0;
        for (int x : list) {
            if (x == 1) cnt++;
            else break;
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
