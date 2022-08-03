package section2;

import java.util.Scanner;

public class Visiblestudent {
    public int solution(int n, int[] students) {
        int answer = 1;
        int max = students[0];
        for (int i = 1; i < n; i++) {
            if (students[i] > max) {
                answer++;
                max = students[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Visiblestudent v = new Visiblestudent();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] students = new int[n];
        for (int i=0; i<n; i++)
            students[i] = sc.nextInt();
        System.out.println(v.solution(n, students));
    }
}
