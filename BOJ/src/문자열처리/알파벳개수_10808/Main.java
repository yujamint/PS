package 문자열처리.알파벳개수_10808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int[] alphabet = new int[26];

        for (char c : input.toCharArray()) {
            int index = c - 97;
            alphabet[index] += 1;
        }

        for (int x : alphabet) {
            System.out.print(x + " ");
        }
    }
}
