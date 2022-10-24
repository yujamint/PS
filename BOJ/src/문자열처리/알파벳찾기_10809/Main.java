package 문자열처리.알파벳찾기_10809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int[] alphabet = new int[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = -1;
        }

        for (char c : input.toCharArray()) {
            int index = c - 97;
            alphabet[index] = input.indexOf(c);
        }

        for (int x : alphabet) {
            System.out.print(x + " ");
        }
    }
}
