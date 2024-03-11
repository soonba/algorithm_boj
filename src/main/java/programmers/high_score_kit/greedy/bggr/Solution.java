package programmers.high_score_kit.greedy.bggr;

import java.util.Stack;

//class Solution {
//    public String solution(String number, int k) {
//        char[] result = new char[number.length() - k];
//        Stack<Character> stack = new Stack<>();
//
//        for (int i=0; i<number.length(); i++) {
//            char c = number.charAt(i);
//            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
//                stack.pop();
//            }
//            stack.push(c);
//        }
//        for (int i=0; i<result.length; i++) {
//            result[i] = stack.get(i);
//        }
//        return new String(result);
//    }
//}
public class Solution {
    static int start = 0;
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        int jari = number.length() - k;
        while(jari > 0) {
            int end = number.length() - jari;
            String result = findMax(number, end);
            sb.append(result);
            jari--;
        }
        return sb.toString();
    }

    private String findMax(String number, int end) {
        int max = 0;
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            int indexNum = number.charAt(i) - '0';
            if(max == indexNum) {
                continue;
            }
            max = Math.max(indexNum, max);
            if(max == indexNum) {
                maxIndex = i;
            }
        }
        start = maxIndex + 1;
        return String.valueOf(max);
    }
}
