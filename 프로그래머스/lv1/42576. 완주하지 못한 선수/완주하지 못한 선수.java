import java.util.HashMap;
import java.util.Map.Entry;

public class Solution {
    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();

        for (String s : participant) {
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            hm.put(s, hm.get(s) - 1);
        }

        for (Entry<String, Integer> entry : hm.entrySet()) {
            if (entry.getValue() != 0) {
                return entry.getKey();
            }
        }

        return "";
    }   
}