package 문자열처리.문자열분석_10820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        while ((input = br.readLine()) != null) {
            int[] arr = new int[4];

            for (char c : input.toCharArray()) {
                if (Character.isLowerCase(c)) arr[0] += 1;
                else if (Character.isUpperCase(c)) arr[1] += 1;
                else if (Character.isDigit(c)) arr[2] += 1;
                else if (Character.isSpaceChar(c)) arr[3] += 1;
            }

            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
