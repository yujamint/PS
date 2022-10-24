package 문자열처리.네수_10824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String AB = st.nextToken() + st.nextToken();
        String CD = st.nextToken() + st.nextToken();

        System.out.println(Long.parseLong(AB) + Long.parseLong(CD));
    }
}
