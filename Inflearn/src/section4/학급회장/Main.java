package section4.학급회장;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public char solution(int n, String str){
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char key : str.toCharArray())
            map.put(key, map.getOrDefault(key,0) + 1);
        int max = Integer.MIN_VALUE;
        for(char key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        System.out.println(m.solution(n, str));
    }
}
