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
        int n = Integer.parseInt(br.readLine());
        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp > 0) positive.add(temp);
            else negative.add(temp);
        }
        Collections.sort(positive);
        Collections.sort(negative);

        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;
        int negIdx = 0, posIdx = positive.size() - 1;
        while (negIdx < negative.size() && posIdx >= 0) {
            int negVal = negative.get(negIdx), posVal = positive.get(posIdx);
            int sum = negVal + posVal;

            if (Math.abs(min) > Math.abs(sum)) {
                min = Math.abs(sum);
                answer[0] = negative.get(negIdx);
                answer[1] = positive.get(posIdx);
            }

            if (sum > 0) {
                posIdx--;
            }
            else {
                negIdx++;
            }
        }

        if (negative.size() >= 2) {
            int lastIdx = negative.size() - 1;
            int temp = negative.get(lastIdx) + negative.get(lastIdx - 1);
            if (Math.abs(min) > Math.abs(temp)) {
                min = Math.abs(temp);
                answer[0] = negative.get(lastIdx - 1);
                answer[1] = negative.get(lastIdx);
            }
        }
        if (positive.size() >= 2) {
            int temp = positive.get(0) + positive.get(1);
            if (Math.abs(min) > Math.abs(temp)) {
                min = Math.abs(temp);
                answer[0] = positive.get(0);
                answer[1] = positive.get(1);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer[0]).append(" ").append(answer[1]);
        System.out.println(sb);
    }

}
