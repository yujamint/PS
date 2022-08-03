package section3.연속부분수열;

import java.util.Scanner;

public class ConsecutiveSubSequence {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = 0, rt = 0;

        while (rt < n) {
            int sum = 0;
            if (lt == rt) sum = arr[lt];
            else {
                for (int i = lt; i <= rt; i++)
                    sum += arr[i];
            }
            if (sum == m) {
                answer++;
                lt++;
                rt++;
            } else if (sum < m) rt++;
            else lt++;

        }
        return answer;
    }

    public static void main(String[] args) {
        ConsecutiveSubSequence m = new ConsecutiveSubSequence();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(m.solution(n, k, arr));
    }
}
