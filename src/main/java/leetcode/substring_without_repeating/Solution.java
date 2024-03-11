package leetcode.substring_without_repeating;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        char[] charArray = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int pointer = 0;
        for (int i = 0 ; i < charArray.length ; i++) {
            char now = charArray[i];
            if(set.contains(now)) {
                //length 등록
                maxLength = Math.max(maxLength,set.size());

                //left ~ 해당번째까지 삭제
                for (int j = pointer; j < charArray.length; j++) {
                    char c = charArray[j];
                    set.remove(c);
                    if(now == c) {
                        pointer = j+1;
                        break;
                    }
                }
            }
            set.add(now);
        }

        return Math.max(set.size(), maxLength);
    }
}
