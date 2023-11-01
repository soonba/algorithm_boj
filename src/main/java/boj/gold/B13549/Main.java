package boj.gold.B13549;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        int s = read();
        int e = read();

        int[] arr = new int[Math.max(s*2+1,e*2+1)];
        Arrays.fill(arr, 100000);
        arr[s] = 0;
        boolean[] visits = new boolean[Math.max(s*2+1,e*2+1)];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        int min = 100000;

        while(!q.isEmpty()) {
            Integer now = q.poll();
            if(now==7) {
                int a = 1;
            }
            if(visits[now]) continue;
            if(now-1 >= 0) {
                arr[now-1] = Math.min(arr[now-1],arr[now]+1);
                q.add(now-1);
            }
            if(now+1 <= e) {
                arr[now+1] = Math.min(arr[now+1],arr[now]+1);
                q.add(now+1);
            }
            if(now*2 <= e+1) {
                arr[now*2] = Math.min(arr[now*2],arr[now]);
                q.add(now*2);
            }
            if(now == e) {
                min = Math.min(min,arr[now]);
            }
            visits[now] = true;
        }
        System.out.println(min);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
