package data_structure.bracket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            Stack<Integer> stack = new Stack<>();
            String[] split = br.readLine().split("");
            String str = "YES";
            for (String s : split) {
                if (s.equals("(")) {
                    stack.push(1);
                } else {
                    if (stack.empty()) {
                        str = "NO";
                        break;
                    }
                    stack.pop();
                }
            }
            if(stack.isEmpty()) {
                System.out.println(str);
            } else {
                System.out.println("NO");
            }

        }
    }
}
