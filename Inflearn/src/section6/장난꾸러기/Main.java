package section6.장난꾸러기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>(2);
        int[] height = arr.clone();
        Arrays.sort(height);
        for(int i=0; i<n; i++)
            if (arr[i] != height[i]) answer.add(i + 1);
        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        for (int x : m.solution(n,arr))
            System.out.print(x + " ");
    }
}
