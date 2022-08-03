package section5.응급실;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
    int id;
    int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }

}

public class Main {
    public int solution(int n, int k, int[] arr) {
        int answer = 0;
        Queue<Person> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            q.offer(new Person(i, arr[i]));
        while (!q.isEmpty()) {
            Person tmp = q.poll();
            for (Person p : q) {
                if (tmp.priority < p.priority) {
                    q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) {
                answer++;
                if (tmp.id == k) return answer;
            }
        }
        return answer;
}

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(m.solution(n, k, arr));
    }
}
