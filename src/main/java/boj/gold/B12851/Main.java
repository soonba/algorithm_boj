package boj.gold.B12851;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        //5
        int s = read();
        int e = read();
        int[] graph = new int[Math.max(e+1,s+1)];
        Arrays.fill(graph,18);
        graph[s] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()) {
            Integer now = q.poll();
            //범위를 넘어가거나, 방문했으면서 지금이 더 큰 경우
            if(now+1 < graph.length) {
               if(graph[now+1] == 0 || graph[now+1] >= graph[now]+1) {

               }
            }
        }

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
