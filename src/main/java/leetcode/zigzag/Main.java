package leetcode.zigzag;

import java.util.Arrays;

//n = 3
//P   A   H   N
//A P L S I I G
//Y   I   R
//01210121012101
//PAYPALISHIRING
//01232101232101
//n = 4
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        char[] charArray = s.toCharArray();
        StringBuilder[] stringBuilderArray = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilderArray[i] = new StringBuilder();
        }
        int numRowsMinus1 = numRows - 1;
        for (int i = 0; i < charArray.length; i++) {
            int mod = i % numRowsMinus1;
            int dev = i / numRowsMinus1;
            boolean isOdd = dev % 2 == 1;
            int index = isOdd ? numRowsMinus1 - mod : mod;
            stringBuilderArray[index].append(charArray[i]);
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(stringBuilderArray).forEach(sb::append);

        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("AB", 1));
        System.out.println(solution.convert("PAYPALISHIRING", 4));
    }
}