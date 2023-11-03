package boj.gold.B16928;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        int l = read();
        int s = read();

        int[] board = new int[100];
        int[] visits = new int[100];

        for (int i = 0; i < l + s; i++) {
            int start = read();
            int end = read();
            board[start - 1] = end - 1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int min = 17;
        while (!q.isEmpty()) {
            Integer index = q.poll();
            int count = visits[index];
            if (index == 99) {
                min = Math.min(min, count);
                continue;
            }
            if (board[index] != 0) {
                q.add(board[index]);
                visits[board[index]] = count;
                continue;
            }
            for (int i = 1; i <= 6; i++) {
                if (index + i == 100) break;
                if (visits[index + i] != 0 && visits[index + i] <= count) continue;
                q.add(index + i);
                visits[index + i] = count + 1;
            }
        }
        System.out.println(min);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
