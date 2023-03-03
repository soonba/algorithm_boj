package data_structure.make_bigger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int length = Integer.parseInt(s[0]);
        int erase = Integer.parseInt(s[1]);
        int resultLength = length - erase;
        char[] chars = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(chars[0]);
        int cur = 0;
        for (int i = 1; i < length; i++) {
            while((!stack.isEmpty()) && (erase > 0) && (chars[i] > stack.peek())) {
                stack.pop();
                erase--;
            }
            if(stack.size() < resultLength) {
                stack.push(chars[i]);
            }
            cur = i+1;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        for (int i = cur; i < length; i++) {
            sb.append(chars[i]);
        }
        System.out.println(sb);
    }
}
