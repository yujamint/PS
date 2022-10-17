package 기초수학.BaseConversion_11576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum += num * Math.pow(A, m - i - 1);
        }

        if (sum == 0)
            sb.append(0);

        while (sum != 0) {
            list.add(sum % B);
            sum /= B;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append(" ");
        }

        System.out.print(sb);
    }
}
