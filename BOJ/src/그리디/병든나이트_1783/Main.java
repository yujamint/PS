package 그리디.병든나이트_1783;

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

        int move = 0;
        int visitCnt = 1;

        if (n == 2) {
            move = (m - 1) / 2;
            visitCnt = Math.min(visitCnt + move, 4);
        }
        else if (n > 2){
            if (m < 7) {
                move = m - 1;
                visitCnt = Math.min(visitCnt + move, 4);
            }
            else {
                move = m - 7;
                visitCnt = visitCnt + move + 4;
            }
        }

        System.out.println(visitCnt);
    }
}
