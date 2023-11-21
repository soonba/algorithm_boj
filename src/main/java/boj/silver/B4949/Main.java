package boj.silver.B4949;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        while(true) {
            boolean result = true;
            Stack<Integer> s = new Stack<>();
            int read;
            boolean next = true;
            while((read = System.in.read()) != 46) {
                next = false;
                if(read == 40 || read == 91) {
                    s.push(read);
                } else if(read == 41) {
                    if(s.isEmpty() || s.pop() != 40) {
                        result = false;
                    }
                } else if(read == 93) {
                    if(s.isEmpty() || s.pop() != 91) {
                        result = false;
                    }
                }
            }
            if(next) break;
            if(!s.isEmpty()) {
                result = false;
            }
            sb.append(result ? "yes" : "no").append("\n");
            System.in.read();
        }
        System.out.println(sb);
    }
}
