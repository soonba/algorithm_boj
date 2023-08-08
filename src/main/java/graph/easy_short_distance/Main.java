package graph.easy_short_distance;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int x= 0, y = 0;


        int[][] map = new int[N][M];
        int[][] cost = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int read = read();
                map[i][j] = read;
                if(read == 2) {
                    x = i;
                    y = j;
                }
                cost[i][j] = N * M;
            }
        }

        StringBuilder sb = new StringBuilder();



        cost[x][y] = 0;
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{x, y});
        while(!q.isEmpty()) {
            int[] poll = q.poll();
            int thisX = poll[0];
            int thisY = poll[1];
            for (int i = 0; i < 4; i++) {
                int nextX = thisX + dx[i];
                int nextY = thisY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M || map[nextX][nextY] == 0) continue;
                if(cost[nextX][nextY] != N * M) {
                    cost[nextX][nextY] = Math.min(cost[nextX][nextY],cost[thisX][thisY] + 1);
                    continue;
                }
                q.add(new int[]{nextX, nextY});
                cost[nextX][nextY] = cost[thisX][thisY] + 1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(cost[i][j] == N*M) {
                    cost[i][j] = map[i][j] == 0 ? 0 : -1;
                }

                sb.append(cost[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
