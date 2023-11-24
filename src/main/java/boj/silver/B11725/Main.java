package boj.silver.B11725;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        int t = read();
        List<Integer>[] arr = new ArrayList[t+1];
        boolean[] visits = new boolean[t+1];
        int[] parents = new int[t+1];
        for (int i = 0; i <= t; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < t-1; i++) {
            int p1 = read();
            int p2 = read();
            arr[p1].add(p2);
            arr[p2].add(p1);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()) {
            Integer now = q.poll();
            visits[now] = true;
            List<Integer> nodes = arr[now];
            for (Integer next : nodes) {
                if (visits[next]) continue;
                q.add(next);
                parents[next] = now;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < parents.length; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb);
    }


    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}