package programmers.high_score_kit.sort.bgst_num;

import java.util.Arrays;

public class Solution {
    public String solution(int[] numbers) {
        String[] array = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(array, (a1,a2) -> {
            int i = Integer.parseInt(a1 + a2);
            int i1 = Integer.parseInt(a2 + a1);
            return i1-i;
        });

        StringBuilder sb = new StringBuilder();
        for (String s : array) {
            sb.append(s);
        }

        return array[0].charAt(0) == '0' ? "0" : sb.toString();
    }
}