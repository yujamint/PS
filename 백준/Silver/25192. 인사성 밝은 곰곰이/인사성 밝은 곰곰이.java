import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int answer = 0;
        boolean isEnterInput = false;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.equals("ENTER")) {
                isEnterInput = true;
                answer += set.size();
                set.clear();
                continue;
            }
            if (isEnterInput && !set.contains(input)) {
                set.add(input);
            }
        }
        if (isEnterInput) {
            answer += set.size();
        }
        System.out.println(answer);
    }
}
