package 그리디.대회or인턴_2875;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int girlTeam = n / 2;

        int possibleTeam = Math.min(girlTeam, m);

        int mod = (n + m) - possibleTeam * 3;

        k -= mod;
        while (k > 0) {
            k -= 3;
            possibleTeam--;
        }

        System.out.println(possibleTeam);
    }
}
