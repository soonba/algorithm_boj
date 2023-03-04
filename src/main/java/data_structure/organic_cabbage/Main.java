package data_structure.organic_cabbage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        for (int i = 0; i < T; i++) {
            int bugCnt = 0;
            String[] s = br.readLine().split(" ");
            int R = Integer.parseInt(s[0]);
            int C = Integer.parseInt(s[1]);
            int cabbageCnt = Integer.parseInt(s[2]);
            boolean[][] matrix = new boolean[R][C];
            for (int j = 0; j < cabbageCnt; j++) {
                String[] s1 = br.readLine().split(" ");
                int i0 = Integer.parseInt(s1[0]);
                int i1 = Integer.parseInt(s1[1]);
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
                                if(tempR < 0 || tempC < 0 || tempR >= R || tempC >= C) continue;
                                if(matrix[tempR][tempC]) {
                                    queue.add(new int[]{tempR,tempC});
                                    matrix[tempR][tempC] = false;
                                }
                            }
                        }
                        bugCnt++;
                    }
                }
            }
            System.out.println(bugCnt);
        }
    }
}
