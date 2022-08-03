package section4.매출액의종류;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public ArrayList<Integer> solution(int n, int k, int[] arr){
        ArrayList<Integer> answer = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0; i<k; i++)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        answer.add(map.size());

        for(int i=0; i<n-k; i++) {
            if(map.get(arr[i]) == 1) map.remove(arr[i]);
            else map.put(arr[i], map.get(arr[i])-1);
            map.put(arr[i+k], map.getOrDefault(arr[i+k], 0) +1);
            answer.add(map.size());
        }
        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        for (int num : m.solution(n, k, arr))
            System.out.print(num + " ");
    }
}
