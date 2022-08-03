package section4.아나그램;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public String solution(String s1, String s2){
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<Character,Integer>();
        for(char key : s1.toCharArray())
            map.put(key, map.getOrDefault(key,0)+1);
        for(char key : s2.toCharArray()){
            if(!map.containsKey(key) || map.get(key) == 0) return "NO";
            map.put(key, map.get(key)-1);
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
