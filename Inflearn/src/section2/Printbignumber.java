package section2;

import java.util.Scanner;

public class Printbignumber {
    public String solutuion(int n, int[] nums){
        String answer="";
        answer += nums[0];
        for(int i=1; i<n; i++) {
            if (nums[i] > nums[i - 1])
                answer += " " + nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Printbignumber p = new Printbignumber();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = sc.nextInt();
        System.out.println(p.solutuion(n,nums));
    }
}
