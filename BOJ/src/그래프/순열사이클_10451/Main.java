package 그래프.순열사이클_10451;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] map;
    static boolean[] ch;

    public static void graph(int idx) {
        if (ch[idx]) return;

        ch[idx] = true;
        graph(map[idx]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int answer = 0;
            ch = new boolean[n+1];
            map = new int[n+1];

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                map[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                if (!ch[j]) {
                    graph(j);
                    answer++;
                }
            }

            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
