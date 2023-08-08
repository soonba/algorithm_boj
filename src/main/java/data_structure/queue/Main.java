package data_structure.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> queue = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] split = br.readLine().split(" ");
            if (split.length == 2 && split[0].equals("push")) {
                push(Integer.parseInt(split[1]));
            }
            else if (split[0].equals("pop")) sb.append(pop()).append("\n");
            else if (split[0].equals("size")) sb.append(size()).append("\n");
            else if (split[0].equals("empty")) sb.append(empty()).append("\n");
            else if (split[0].equals("front")) sb.append(front()).append("\n");
            else if (split[0].equals("back")) sb.append(back()).append("\n");
        }

        System.out.println(sb);
    }

    static void push(int n) {
        queue.add(n);
    }

    static int pop() {
        if (queue.isEmpty()) return -1;
        return queue.remove(0);
    }

    static int size() {
        return queue.size();
    }

    static int empty() {
        return queue.isEmpty() ? 1 : 0;
    }

    static int front() {
        if (queue.isEmpty()) return -1;
        return queue.get(0);
    }

    static int back() {
        if (queue.isEmpty()) return -1;
        return queue.get(queue.size() - 1);
    }
}
