package implementation.fine_dust;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] room;
    static int[][] tempRoom;
    static int R;
    static int C;
    static List<Integer> airCleanerRows = new ArrayList<>();

    //for 문에서 상하좌우 탐색용
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().split(" ");

        R = Integer.parseInt(S[0]);
        C = Integer.parseInt(S[1]);
        int T = Integer.parseInt(S[2]);
        room = new int[R][C];

        for (int i = 0; i < R; i++) {
            String[] SS = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                int now = Integer.parseInt(SS[j]);
                room[i][j] = now;
                if(now == -1) {
                    //i행 1열
                    airCleanerRows.add(i);
                }
            }
        }

        for (int i = 0; i < T; i++) {
            fineDustProcess();
            airCleanerProcess();
        }

        int score = calcFineDustScore();
        System.out.println(score);
    }

    private static int calcFineDustScore() {
        int score = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int now = room[i][j];
                if(now == -1) continue;
                score += now;
            }
        }
        return score;
    }

    private static void airCleanerProcess() {
        upperCleanerProcess();
        lowerCleanerProcess();
    }

    private static void lowerCleanerProcess() {
        Integer r = airCleanerRows.get(1);

        for (int i = r+1; i < R-1; i++) {
            room[i][0] = room[i+1][0];
        }

        for (int i = 0; i < C-1; i++) {
            room[R-1][i] = room[R-1][i+1];
        }

        for (int i = R-1; i > r; i--) {
            room[i][C-1] = room[i-1][C-1];
        }

        for (int i = C-1; i > 1; i--) {
            room[r][i] = room[r][i-1];
        }

        room[r][1] = 0;
    }

    private static void upperCleanerProcess() {
        Integer r = airCleanerRows.get(0);

        for (int i = r-1; i > 0; i--) {
            room[i][0] = room[i-1][0];
        }

        for (int i = 0; i < C-1; i++) {
            room[0][i] = room[0][i+1];
        }

        for (int i = 0; i < r; i++) {
            room[i][C-1] = room[i+1][C-1];
        }

        for (int i = C-1; i > 1; i--) {
            room[r][i] = room[r][i-1];
        }

        room[r][1] = 0;
    }

    private static void fineDustProcess() {
        tempRoom = new int[R][C];
        Integer r1 = airCleanerRows.get(0);
        tempRoom[r1][0] = -1;
        tempRoom[r1+1][0] = -1;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int now = room[i][j];
                if(now == 0 || now == -1) continue;
                spreadsProcess(i,j);
            }
        }
        room = tempRoom;
    }

    private static void spreadsProcess(int r, int c) {
        int now = room[r][c];
        int addValue = now / 5;
        int addCount = 0;
        for (int i = 0; i < 4; i++) {
            int tempR = r + dx[i];
            int tempC = c + dy[i];
            if(tempR < 0 || tempR >= R || tempC < 0 || tempC >= C || room[tempR][tempC] == -1) continue;
            tempRoom[tempR][tempC] += addValue;
            addCount++;
        }
        tempRoom[r][c] += now - (addCount * addValue);
    }
}