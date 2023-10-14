package boj.gold.B1987;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int R;
    static int C;
    static int[][] graph;

    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().split(" ");
        R = Integer.parseInt(S[0]);
        C = Integer.parseInt(S[1]);

        graph = new int[R][C];
        for (int i = 0; i < R; i++) {
            char[] temp = br.readLine().toCharArray();
            if (C >= 0) System.arraycopy(temp, 0, graph[i + 1], 1, C);
        }


        boolean[] visits = new boolean[26];
        visits[graph[0][0]] = true;
        dfs(0, 0, 1, visits);

        System.out.println(max);
    }

    private static void dfs(int r, int c, int cnt, boolean[] visits) {
        for (int i = 0; i < 4; i++) {
            int nextR = r + dx[i];
            int nextC = c + dy[i];

            max = Math.max(max, cnt);
            if (nextR < 0 || nextC < 0 || nextR >= R || nextC >= C) continue;
            if (visits[graph[nextR][nextC]]) continue;

            boolean[] newVisits = Arrays.copyOf(visits, 26);
            newVisits[graph[nextR][nextC]] = true;
            dfs(nextR, nextC, cnt + 1, newVisits);
        }
    }

}
