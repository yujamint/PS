package section6.LRU;

import java.util.Scanner;

public class Main {
    public int[] solution(int s, int n, int[] arr){
        int[] answer = new int[s];
        answer[0] = arr[0];
        for(int i=1; i<n; i++){
            int index = 0;

            boolean contain = false;
            for(int j=0; j<s; j++)
                if(arr[i] == answer[j]) {
                    index = j;
                    contain=true;
                    break;
                }

            if(!contain)  // Cache Miss
                for (int j = s - 1; j > 0; j--) answer[j] = answer[j - 1];
            else // Cache Hit
                for (int j = index; j > 0; j--) answer[j] = answer[j - 1];
            answer[0] = arr[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        for(int i : m.solution(s, n,arr))
            System.out.print(i + " ");
    }
}


