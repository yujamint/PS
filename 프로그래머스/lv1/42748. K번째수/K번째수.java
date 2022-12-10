import java.util.Arrays;

public class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int start;
        int end;
        int K;
        int[] answer = new int[commands.length];

        for (int test = 0; test < commands.length; test++) {
            int[] command = commands[test];
            start = command[0];
            end = command[1];
            K = command[2];

            int len = end - start + 1;

            int[] arr = new int[len];

            for (int i = 0; i < len; i++) {
                arr[i] = array[i + start - 1];
            }

            Arrays.sort(arr);

            answer[test] = arr[K - 1];
        }

        return answer;
    }
}
