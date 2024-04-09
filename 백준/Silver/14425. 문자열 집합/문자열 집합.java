import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            map.put(str, 0);
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if (map.containsKey(str)) count++;
        }

        System.out.println(count);
    }
}