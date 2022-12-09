package DP.팰린드롬분할_1509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static String input;
    static int[] dp;
    static Stack<Character> stack;

    public static void solution(int index) {
        char ch = input.charAt(index);
        if (stack.contains(ch)) {

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stack = new Stack<>();

        input = br.readLine();

        dp = new int[input.length()];

        dp[0] = 1;
    }
}
