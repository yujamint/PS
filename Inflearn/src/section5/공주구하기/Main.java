package section5.공주구하기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public int solution(int n, int k){
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++)
            queue.offer(i);
        while(queue.size()!=1){
            for(int i=1;i<k;i++)
                queue.offer(queue.poll());
            queue.poll();
        }
        answer = queue.peek();
        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(m.solution(n,k));
    }
}

