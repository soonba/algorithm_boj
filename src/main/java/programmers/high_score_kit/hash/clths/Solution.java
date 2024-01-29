package programmers.high_score_kit.hash.clths;

import java.util.HashMap;
import java.util.Set;

public class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String key = clothe[1];
            Integer cnt = map.getOrDefault(key, 0);
            map.put(key, cnt + 1);
        }
        Set<String> keySet = map.keySet();
        int combSum = 1;
        for (String key: keySet) {
            Integer i = map.get(key);
            combSum *= i+1;
        }
        return combSum -1 ;
    }
}