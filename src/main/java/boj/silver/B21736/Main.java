package boj.silver.B21736;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//3 5
//OOOPO
//OIOOX
//OOOXP
public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int R;
    static int C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] split = s.split(" ");
        R = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);
        int startR = 0;
        int startC = 0;
        String[][] graph = new String[R][C];
        for (int i = 0; i < R; i++) {
            String s1 = br.readLine();
            String[] split1 = s1.split("");
            for (int j = 0; j < split1.length; j++) {
                graph[i][j] = split1[j];
                if (split1[j].equals("I")) {
                    startR = i;
                    startC = j;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startR, startC});
        graph[startR][startC] = "X";
        int count = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowR = now[0];
            int nowC = now[1];

            for (int i = 0; i < 4; i++) {
                int nextR = nowR + dx[i];
                int nextC = nowC + dy[i];

                if (nextR >= R || nextR < 0 || nextC >= C || nextC < 0 || graph[nextR][nextC].equals("X")) continue;
                q.add(new int[]{nextR, nextC});
                if (graph[nextR][nextC].equals("P")) count++;
                graph[nextR][nextC] = "X";
            }
        }
        String message = count == 0 ? "TT" : String.valueOf(count);
        System.out.println(message);
    }

}
