package 문자열처리.접미사배열_11656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        String[] arr = new String[input.length()];

        for (int i = 0; i < input.length(); i++) {
            arr[i] = input.substring(i, input.length());
        }

        Arrays.sort(arr);

        for (String str : arr) {
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }
}
