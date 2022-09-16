package 완전탐색.소수의연속합_1644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int n;
    static ArrayList<Integer> list = new ArrayList<>();
    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int answer = 0;

        if (n==1) {
            System.out.println(0);
            return;
        }

        prime = new boolean[n + 1];
        prime[0] = prime[1] = false;

        for (int i = 2; i <= n; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            for (int j = i * i; j <= n; j += i) {
                prime[j] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i]) list.add(i);
        }

        int front = 0, rear = 0, sum=list.get(0);
        while (front <= rear) {
            if (sum <= n) {
                if (sum == n) answer++;
                if (rear >= list.size()-1) break;
                rear++;
                sum += list.get(rear);
            }
            else {
                sum -= list.get(front);
                front++;
            }
        }
        System.out.println(answer);
    }
}
