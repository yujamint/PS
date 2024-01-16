import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer input;
        Set<String> set = new HashSet<>();
        set.add("ChongChong");
        for (int i = 0; i < N; i++) {
            input = new StringTokenizer(br.readLine());
            String A = input.nextToken();
            String B = input.nextToken();
            if (set.contains(A) || set.contains(B)) {
                set.add(A);
                set.add(B);
            }
        }
        System.out.println(set.size());
    }
}
