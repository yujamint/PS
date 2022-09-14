package 완전탐색.암호만들기_1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char[] chs, selected;
    static char[] aeiou = {'a', 'e', 'i', 'o', 'u'};

    public static void DFS(int count, int start) {
        if (count == L) {
            boolean flag = false;
            int cnt = 0;

            for (int i = 0; i < L; i++) {
                boolean flag2 = false;
                for (int j = 0; j < 5; j++) {
                    if (selected[i] == aeiou[j]) {
                        flag = true;
                        flag2 = true;
                    }
                }
                if (!flag2) cnt++;
            }

            if (flag && cnt >= 2) {
                for (char x : selected) {
                    System.out.print(x);
                }
                System.out.println("");
            }
        } else {
            for (int i = start; i < C; i++) {
                selected[count] = chs[i];
                DFS(count + 1, i + 1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        String temp = br.readLine();
        chs = new char[C];
        selected = new char[L];
        for (int i = 0; i < C; i++) {
            chs[i] = temp.charAt(2 * i);
        }

        Arrays.sort(chs);

        DFS(0, 0);
    }
}
