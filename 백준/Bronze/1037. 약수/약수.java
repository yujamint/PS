import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer input = new StringTokenizer(br.readLine());
        List<Integer> divisors = new ArrayList<>(count);
        while (input.hasMoreTokens()) {
            divisors.add(Integer.parseInt(input.nextToken()));
        }
        Collections.sort(divisors);

        int answer;
        if (divisors.size() == 1) answer = divisors.get(0) * divisors.get(0);
        else answer = divisors.get(0) * divisors.get(divisors.size() - 1);

        System.out.println(answer);
    }
}
