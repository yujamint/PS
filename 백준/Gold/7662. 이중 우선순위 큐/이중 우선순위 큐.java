import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int T = 0; T < t; T++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < k; i++) {
                char command = (char) br.read();
                br.skip(1);
                switch (command) {
                    case 'I':
                        int num = Integer.parseInt(br.readLine());
                        map.put(num, map.getOrDefault(num, 0) + 1);
                        break;
                    case 'D':
                        int type = Integer.parseInt(br.readLine());
                        if (map.isEmpty()) break;
                        if (type == 1) {
                            int key = map.lastKey();
                            int cnt = map.get(key);
                            if (cnt == 1) map.remove(key);
                            else map.replace(key, cnt - 1);
                        } else {
                            int key = map.firstKey();
                            int cnt = map.get(key);
                            if (cnt == 1) map.remove(key);
                            else map.replace(key, cnt - 1);
                        }
                }
            }
            if (map.isEmpty()) {
                sb.append("EMPTY").append('\n');
            }
            else {
                sb.append(map.lastKey()).append(' ').append(map.firstKey()).append('\n');
            }
        }
        System.out.println(sb);
    }

}
