package section8.최대점수구하기;

import java.util.Scanner;

class Question {
    int score;
    int time;
    public Question(int score, int time){
        this.score = score;
        this.time = time;
    }
}

public class Main {
    static int n,m;
    static int score = 0, time = 0, answer = Integer.MIN_VALUE;

    public void DFS(int L, int score, int time, Question[] arr) {
        if(time > m) return;
        if(L==n) {
            answer = Math.max(answer,score);
        }
        else {
            DFS(L+1, score + arr[L].score, time + arr[L].time, arr);
            DFS(L+1, score, time, arr);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Question[] arr = new Question[n];
        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[i] = new Question(a,b);
        }
        T.DFS(0,score, time, arr);
        System.out.println(answer);
    }
}
