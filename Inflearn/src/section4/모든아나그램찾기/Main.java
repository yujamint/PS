package section4.모든아나그램찾기;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public int solution(String s1, String s2){
        int answer = 0;
        HashMap<Character, Integer> map1 = new HashMap<Character,Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character,Integer>();
        char[] chs = s1.toCharArray();
        int lt = 0;
        for(char x : s2.toCharArray())
            map1.put(x, map1.getOrDefault(x, 0)+1);
        for(int i=0; i<s2.length()-1; i++) {
            map2.put(chs[i], map2.getOrDefault(chs[i],0)+1);
        }
        for(int rt=s2.length()-1; rt<chs.length; rt++){
            map2.put(chs[rt], map2.getOrDefault(chs[rt],0)+1);
            if(map1.equals(map2)) answer++;
            map2.put(chs[lt], map2.get(chs[lt])-1);
            if (map2.get(chs[lt]) == 0) map2.remove(chs[lt]);
            lt++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(m.solution(str1, str2));
    }
}
