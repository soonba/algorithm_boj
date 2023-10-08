package data_structure.postfix_notation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/*
1. 기존 괄호(존재한다면)와 연산자 우선순위에 맞는 괄호를 추가하여 모든 괄호가 추가된 문자열을 만든다.
2. 모든 괄호가 추가된 문자열로 후위표기식을 만든다.

우선순위 높은 연산자 / 낮은 연산자를 나눈다.
 */
public class Main {

    public static final List<Character> high = List.of('*', '/');
    public static final List<Character> low = List.of('+', '-');
    public static final List<Character> operator = List.of('*', '/', '+', '-');

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();

        //우선순위 높은 괄호 추가
        String addHigh = addBracketsAtOperator(target, high);

        //우선순위 낮은 괄호 추가
        String addResult = addBracketsAtOperator(addHigh, low);

        // 괄호가 모두 추가된 문자열을 후위 표기식으로 변환
        String result = convertPostfixNotation(addResult);
        System.out.println(result);
    }

    public static String addBracketsAtOperator(String target, List<Character> includeOperator) {
        StringBuilder sb = new StringBuilder(target);
        int varLength = target.length();

        // 괄호가 추가됨에따라 for 문의 순회 횟수가 가변적임
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

    // 현재 인덱스보다 작으면서 가장 가까운 여는 괄호를 찾는 메서드
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

    // 현재 인덱스보다 크면서 가장 가까운 닫힌 괄호를 찾는 메서드
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

        // O(n) 으로 연산자를 만나게되면, 후위표현식으로 변경하고 이미 변경된 연산자임을 체크(moved)
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
