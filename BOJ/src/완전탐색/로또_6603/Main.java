package 완전탐색.로또_6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr, selected, ch;


    public static void DFS(int count) {
        if (count == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println("");
        }
        else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    selected[count] = arr[i];
                    DFS(count + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals("0")) return;

            StringTokenizer st = new StringTokenizer(input, " ");
            n = Integer.parseInt(st.nextToken());
            arr = new int[n];
            selected = new int[6];
            ch = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            DFS(0);

            System.out.println("");
        }


    }
}
