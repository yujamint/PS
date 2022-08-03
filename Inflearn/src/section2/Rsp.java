package section2;

import java.util.Scanner;

public class Rsp {
    public char[] solution(int n, int[] a, int[] b) {
        char[] answer = new char[n];

        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) answer[i] = 'D';
            else if (a[i] - b[i] == 1 || a[i] - b[i] == -2)
                answer[i] = 'A';
            else
                answer[i] = 'B';

        }
        return answer;
    }

    public static void main(String[] args) {
        Rsp r = new Rsp();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n], b = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 0; i < n; i++) b[i] = sc.nextInt();
        for (int i = 0; i < n; i++) System.out.println(r.solution(n, a, b)[i]);
    }
}
