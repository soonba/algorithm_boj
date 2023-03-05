package data_structure.organic_cabbage;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        int T = read();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int bugCnt = 0;
            int R = read();
            int C = read();
            int cabbageCnt = read();
            boolean[][] matrix = new boolean[R][C];
            for (int j = 0; j < cabbageCnt; j++) {
                int i0 = read();
                int i1 = read();
                matrix[i0][i1] = true;
            }

            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    if (matrix[j][k]) {
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{j, k});
                        matrix[j][k] = false;
                        while (!queue.isEmpty()) {
                            int[] now = queue.poll();
                            int nowR = now[0];
                            int nowC = now[1];
                            for (int l = 0; l < 4; l++) {
                                int tempR = nowR + dx[l];
                                int tempC = nowC + dy[l];
                                if (tempR < 0 || tempC < 0 || tempR >= R || tempC >= C) continue;
                                if (matrix[tempR][tempC]) {
                                    queue.add(new int[]{tempR, tempC});
                                    matrix[tempR][tempC] = false;
                                }
                            }
                        }
                        bugCnt++;
                    }
                }
            }
            sb.append(bugCnt).append("\n");
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
