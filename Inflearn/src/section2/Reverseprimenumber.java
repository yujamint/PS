package section2;

import java.util.ArrayList;
import java.util.Scanner;

public class Reverseprimenumber {
    public ArrayList<Integer> solution(int[] nums){
        ArrayList<Integer> temp = new ArrayList<Integer>();
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for (int i=0; i<nums.length; i++) {
            StringBuffer sb = new StringBuffer(Integer.toString(nums[i]));
            temp.add(Integer.parseInt(sb.reverse().toString()));
        }
        for (int i=0; i<temp.size(); i++){
            int divided = 1;
            for (int j=1; j<=Math.sqrt(temp.get(i)); j++)
                if (temp.get(i) % j == 0) divided = j;
            if (divided == 1 && temp.get(i) != 1)
                answer.add(temp.get(i));
        }
        return answer;
    }

    public static void main(String[] args) {
        Reverseprimenumber r = new Reverseprimenumber();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = sc.nextInt();
        for (int i : r.solution(nums))
            System.out.print(i + " ");

    }
}
