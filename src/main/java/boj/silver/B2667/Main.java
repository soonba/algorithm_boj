package boj.silver.B2667;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int[] dx = { 1, -1, 0, 0};
    static int[] dy = { 0,  0, 1,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < split.length; j++) {
                graph[i][j] = Integer.parseInt(split[j]);
            }
        }
        StringBuilder sb = new StringBuilder();
        Queue<Integer> qu = new PriorityQueue<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(graph[i][j] == 0) continue;
                Queue<int[]> q = new LinkedList<>();
                graph[i][j] = 0;
                q.add(new int[]{i,j});
                int smallCount = 1;
                while(!q.isEmpty()) {
                    int[] now = q.poll();
                    int nowX = now[0];
                    int nowY = now[1];
                    for (int k = 0; k < 4; k++) {
                        int tempX = nowX + dx[k];
                        int tempY = nowY + dy[k];
                        if(tempX < 0 || tempY < 0 || tempX >= N || tempY >= N) continue;
                        if(graph[tempX][tempY] == 0) continue;
                        graph[tempX][tempY] = 0;
                        q.add(new int[]{tempX,tempY});
                        smallCount++;
                    }
                }
                qu.add(smallCount);
                count++;
            }
        }
        sb.append(count).append("\n");
        while (!qu.isEmpty()) {
            sb.append(qu.poll()).append("\n");
        }
        System.out.println(sb);
    }

}