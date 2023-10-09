package boj.silver.B10828;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        MyStack stack = new MyStack();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] S = br.readLine().split(" ");
            String order = S[0];
            if (order.equals("push")) {
                Integer S2 = Integer.parseInt(S[1]);
                stack.push(S2);
            } else if (order.equals("pop")) {
                sb.append(stack.pop()).append("\n");
            } else if (order.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if (order.equals("empty")) {
                sb.append(stack.empty()).append("\n");
            } else if (order.equals("top")) {
                sb.append(stack.top()).append("\n");

            }
        }

        System.out.println(sb);

    }
}

class MyStack {
    private int idx;
    private final int[] elements;

    public MyStack() {
        idx = 0;
        elements = new int[10001];
    }

    public void push(int n) {
        elements[idx++] = n;
    }

    public int pop() {
        if (idx == 0) return -1;
        return elements[--idx];
    }

    public int size() {
        return idx;
    }

    public int empty() {
        return idx == 0 ? 1 : 0;
    }

    public int top() {
        if (idx == 0) return -1;
        return elements[idx - 1];
    }
}
