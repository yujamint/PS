package section5.크레인인형뽑기;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public int solution(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();

        for(int move : moves){
            for(int i=0; i<n; i++){
                if(board[i][move-1] != 0){
                    int doll = board[i][move-1];
                    board[i][move-1] = 0;

                    if(!basket.isEmpty() && basket.peek() == doll){
                        answer+=2;
                        basket.pop();
                    } else basket.push(doll);

                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = sc.nextInt();
        int s = sc.nextInt();
        int[] moves = new int[s];
        for (int i = 0; i < s; i++)
            moves[i] = sc.nextInt();
        System.out.println(m.solution(n, board, s, moves));
    }
}