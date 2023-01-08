package unclassified.stack_sequence;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T; i++) {
            int nextInt = Integer.parseInt(br.readLine());
            if (count < nextInt) {
                for (int j = count; j < nextInt; j++) {
                    stack.push(++count);
                    sb.append("+\n");
                }
            } else {
                if (stack.peek() != nextInt) {
                    sb.replace(0, sb.length(), "NO");
                    break;
                }
            }
            stack.pop();
            sb.append("-\n");
        }
        System.out.println(sb);
    }
}
