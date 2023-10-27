package boj.gold.B9019;

import java.util.LinkedList;
import java.util.Queue;

//3
//1234 3412
//1000 1
//1 16
public class Main {

    public static void main(String[] args) throws Exception {
        int T = read();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int st = read();
            int e = read();

            String[] commands = new String[10000];
            boolean[] visits = new boolean[10000];

            Queue<Integer> q = new LinkedList<>();
            q.add(st);
            visits[st] = true;
            commands[st] = "";

            String result = "";

            while(!q.isEmpty()) {
                int now = q.poll();
                int d = (now * 2) % 10000;
                int s = now == 0 ? 9999 : now-1;
                int l = (now % 1000) * 10 + now/1000;
                int r = (now % 10) * 1000 + now/10;

                if(now == e) {
                    result = commands[now];
                    break;
                }
                if(!visits[d]) {
                    visits[d] = true;
                    commands[d] = commands[now] + 'D';
                    q.add(d);
                }

                if(!visits[s]) {
                    visits[s] = true;
                    commands[s] = commands[now] + 'S';
                    q.add(s);
                }

                if(!visits[l]) {
                    visits[l] = true;
                    commands[l] = commands[now] + 'L';
                    q.add(l);
                }

                if(!visits[r]) {
                    visits[r] = true;
                    commands[r] = commands[now] + 'R';
                    q.add(r);
                }
            }

            sb.append(result).append("\n");

        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}