package data_structure.least_heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        int T = read();
        Queue<Integer> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int next = read();
            if (next == 0) {
                if (!queue.isEmpty()) {
                    sb.append(queue.poll()).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else {
                queue.add(next);
            }
        }

        System.out.println(sb);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
