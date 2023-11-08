package boj.gold.B2206;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int R, C;
    static int min = Integer.MAX_VALUE;
    static int[][] graph;

    public static void main(String[] args) throws Exception {
        R = read();
        C = read();
        graph = new int[R][C];
        int[][][] visits = new int[R][C][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                graph[i][j] = System.in.read() - 48;
            }
            System.in.read();
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            depth++;
            while(size-->0) {
                int[] now = q.poll();
                int nowR = now[0];
                int nowC = now[1];
                int nowWall = now[2];
                if (nowR == R - 1 && nowC == C - 1) {
                    min = Math.min(min, depth);
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int nextR = nowR + dx[i];
                    int nextC = nowC + dy[i];
                    if (nextR >= R || nextR < 0 || nextC >= C || nextC < 0) continue;
                    //다음에 가려는 칸이 이미 방문했을 경우
                    if (visits[nextR][nextC][nowWall] == 1) continue;
                    if (graph[nextR][nextC] == 1) {
                        //다음이 벽인데 이미 벽을 부수고 온 경우 스킵
                        if (nowWall == 1) continue;
                        //아닌 경우 부수며 이동하고 방문
                        q.add(new int[]{nextR, nextC, 1});
                        visits[nextR][nextC][1] = 1;
                    } else {
                        //다음이 길인경우 기존의 벽이용 정보대로 큐에 추가
                        q.add(new int[]{nextR, nextC, nowWall});
                        visits[nextR][nextC][nowWall] = 1;
                    }

                }
            }
        }
        int result = min == Integer.MAX_VALUE ? -1 : min;
        System.out.println(result);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
