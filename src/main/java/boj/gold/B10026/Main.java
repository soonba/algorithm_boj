package boj.gold.B10026;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0,  0, 1,-1};
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] graph = new char[N][N];
        boolean[][] visits = new boolean[N][N];
        boolean[][] visits2 = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            char[] charArray = s.toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                graph[i] = charArray;
            }
        }

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (visits[i][j]) continue;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i,j});
                visits[i][j] = true;
                while(!q.isEmpty()) {
                    int[] poll = q.poll();
                    int nowR = poll[0];
                    int nowC = poll[1];
                    char now = graph[nowR][nowC];
                    for (int k = 0; k < 4; k++) {
                        int tempR = nowR + dx[k];
                        int tempC = nowC + dy[k];

                        if(tempR < 0 || tempR >= N || tempC < 0 || tempC >= N) continue;
                        if(graph[tempR][tempC] == now && !visits[tempR][tempC]) {
                            visits[tempR][tempC] = true;
                            q.add(new int[]{tempR,tempC});
                        }
                    }
                }
                count1++;
            }

            for (int j = 0; j < graph[i].length; j++) {
                if (visits2[i][j]) continue;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i,j});
                visits2[i][j] = true;
                while(!q.isEmpty()) {
                    int[] poll = q.poll();
                    int nowR = poll[0];
                    int nowC = poll[1];
                    char now = graph[nowR][nowC];
                    boolean isBlue = now == 'B';
                    for (int k = 0; k < 4; k++) {
                        int tempR = nowR + dx[k];
                        int tempC = nowC + dy[k];

                        if(tempR < 0 || tempR >= N || tempC < 0 || tempC >= N) continue;
                        char next = graph[tempR][tempC];
                        if((next == now || (!isBlue && next != 'B'))  && !visits2[tempR][tempC]) {
                            visits2[tempR][tempC] = true;
                            q.add(new int[]{tempR,tempC});
                        }
                    }
                }
                count2++;
            }
        }
        System.out.println(count1 + " " + count2);
    }
}