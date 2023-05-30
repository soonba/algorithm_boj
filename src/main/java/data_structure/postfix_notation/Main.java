package data_structure.postfix_notation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static final List<Character> high = List.of('*', '/');
    public static final List<Character> low = List.of('+', '-');
    public static final List<Character> operator = List.of('*', '/', '+', '-');

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String addHigh = addBracketsAtOperator(target, high);
        String addResult = addBracketsAtOperator(addHigh, low);
        String result = convertPostfixNotation(addResult);
        System.out.println(result);
    }

    public static String addBracketsAtOperator(String target, List<Character> includeOperator) {
        StringBuilder sb = new StringBuilder(target);
        int varLength = target.length();
        for (int i = 0; i < varLength; i++) {
            char c = sb.charAt(i);
            if (includeOperator.contains(c)) {

                // ) 붙이기
                char next = sb.charAt(i + 1);
                if (next == '(') {
                    int index = findCloseIndex(sb, i);
                    sb.insert(index + 1, ")");
                } else {
                    sb.insert(i + 2, ")");
                }

                // ( 붙이기
                char before = sb.charAt(i - 1);
                if (before == ')') {
                    int index = findOpenIndex(sb,i);
                    sb.insert(index, "(");
                } else {
                    sb.insert( i-1, "(" );
                }
                varLength = varLength + 2;
                i++;
            }
        }
        return sb.toString();
    }

    public static int findOpenIndex(StringBuilder sb, int i) {
        // i 포함 안 됨
        String substring = sb.substring(0, i);
        String[] split = substring.split("");
        int stack = 0;
        for (int j = split.length-1; j >= 0 ; j--) {
            if(split[j].equals(")")) stack ++;
            if(split[j].equals("(")) stack --;
            if(stack ==0) return j;
        }
        throw new RuntimeException("괄호 이상");
    }

    public static int findCloseIndex(StringBuilder sb, int i) {
        String substring = sb.substring(i);
        String[] split = substring.split("");
        int stack = 0;
        for (int j = 1; j < split.length; j++) {
            if (split[j].equals("(")) stack++;
            if (split[j].equals(")")) stack--;
            if (stack == 0) return j + i;
        }
        throw new RuntimeException("괄호 이상");
    }

    public static String convertPostfixNotation(String addResult) {
        StringBuilder sb = new StringBuilder(addResult);
        boolean[] moved = new boolean[sb.length()];

        for (int i = 0; i < sb.length(); i++) {
            char now = sb.charAt(i);
            if(!isOperator(now)) continue;
            if(moved[i]) continue;
            char next = sb.charAt(i + 1);
            int index = next == '(' ? findCloseIndex(sb, i) : i+1;
            sb.deleteCharAt(i);
            sb.insert(index,now);
            moved[index] = true;
        }
        return sb.toString()
                .replaceAll("[()]","");
    }

    private static boolean isOperator(char now) {
        return operator.contains(now);
    }
}
