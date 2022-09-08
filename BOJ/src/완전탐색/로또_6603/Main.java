package 완전탐색.로또_6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr, selected;


    public static void DFS(int count, int start) {
        if (count == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println("");
        }
        else {
            for (int i = start; i < n; i++) {
                selected[count] = arr[i];
                DFS(count + 1, i + 1);
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

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            DFS(0,0);

            System.out.println("");
        }


    }
}
