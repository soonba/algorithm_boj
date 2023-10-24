package boj.gold.B14500;

public class Main {
    static int R, C;
    static int[][] graph;
    static int max = 0;
    public static void main(String[] args) throws Exception {
        R = read();
        C = read();
        graph = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                graph[i][j] = read();
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                processO(i,j);
                processI(i,j);
                processT(i,j);
                processL(i,j);
                processS(i,j);
            }
        }
        System.out.println(max);
    }

    private static void processS(int r, int c) {
        //하드코딩
        int[] dx  = { 1,  1, -1, -1, 0, 0, 0, 0};
        int[] dy  = { 0,  0,  0,  0, 1, 1,-1,-1};

        int[] dx2 = { 1,  1, -1, -1,-1, 1,-1, 1};
        int[] dy2 = { 1, -1,  1, -1, 1, 1,-1,-1};

        int[] dx3 = { 2,  2, -2, -2,-1, 1,-1, 1};
        int[] dy3 = { 1, -1,  1, -1, 2, 2,-2,-2};

        for (int i = 0; i < 8; i++) {
            int nextX = r+dx[i];
            int nextY = c+dy[i];
            int nextX2 = r+dx2[i];
            int nextY2 = c+dy2[i];
            int nextX3 = r+dx3[i];
            int nextY3 = c+dy3[i];
            if(nextX >= R || nextX < 0 || nextY >= C || nextY < 0 ||
                    nextX2 >= R || nextX2 < 0 || nextY2 >= C || nextY2 < 0 ||
                    nextX3 >= R || nextX3 < 0 || nextY3 >= C || nextY3 < 0) continue;
            int sum = graph[r][c];
            sum += graph[nextX][nextY];
            sum += graph[nextX2][nextY2];
            sum += graph[nextX3][nextY3];
            max = Math.max(max, sum);
        }

    }

    private static void processL(int r, int c) {
        int[] dx =  { 2,  2,  -2, -2, 1, -1,  1, -1};
        int[] dy =  { 1, -1,   1, -1, 2,  2, -2, -2};

        for (int i = 0; i < 8; i++) {
            int nextX = r+dx[i];
            int nextY = c+dy[i];
            if(nextX >= R || nextX < 0 || nextY >= C || nextY < 0) continue;
            int sum = 0;
            if(nextX == r+2) {
                for (int j = r; j <= nextX; j++) {
                    sum += graph[j][c];
                }
            } else if (nextX == r-2) {
                for (int j = nextX; j <= r; j++) {
                    sum += graph[j][c];
                }
            } else if (nextY == c+2) {
                for (int j = c; j <= nextY; j++) {
                    sum += graph[r][j];
                }
            } else {
                for (int j = nextY; j <= c; j++) {
                    sum += graph[r][j];
                }
            }
            sum += graph[nextX][nextY];
            max = Math.max(max, sum);
        }
    }

    private static void processT(int r, int c) {
        int[] dx  = { 1, -1,  0,  0};
        int[] dy  = { 0,  0, -1,  1};

        int[] dx2 = { 0,  0, -1, -1};
        int[] dy2 = {-1, -1,  0,  0};

        int[] dx3 = { 0,  0,  1,  1};
        int[] dy3 = { 1,  1,  0,  0};


        for (int i = 0; i < 4; i++) {
            int nextX = r+dx[i];
            int nextY = c+dy[i];
            int nextX2 = r+dx2[i];
            int nextY2 = c+dy2[i];
            int nextX3 = r+dx3[i];
            int nextY3 = c+dy3[i];
            if(nextX >= R || nextX < 0 || nextY >= C || nextY < 0 ||
                    nextX2 >= R || nextX2 < 0 || nextY2 >= C || nextY2 < 0 ||
                    nextX3 >= R || nextX3 < 0 || nextY3 >= C || nextY3 < 0) continue;
            int sum = graph[r][c];
            sum += graph[nextX][nextY];
            sum += graph[nextX2][nextY2];
            sum += graph[nextX3][nextY3];
            max = Math.max(max, sum);
        }
    }

    private static void processO(int r, int c) {
        int[] dx = {1, -1,  1, -1};
        int[] dy = {1, -1, -1,  1};
        for (int i = 0; i < 4; i++) {
            int nextX = r+dx[i];
            int nextY = c+dy[i];
            if(nextX >= R || nextX < 0 || nextY >= C || nextY < 0) continue;
            int sum = graph[r][c];
            sum += graph[nextX][c];
            sum += graph[r][nextY];
            sum += graph[nextX][nextY];
            max = Math.max(max, sum);
        }
    }

    private static void processI(int r, int c) {
        int[] dx = {3, -3, 0, 0};
        int[] dy = {0, 0, 3, -3};
        for (int i = 0; i < 4; i++) {
            int nextX = r+dx[i];
            int nextY = c+dy[i];
            if(nextX >= R || nextX < 0 || nextY >= C || nextY < 0) continue;
            int sum = 0;
            if(nextX >= r || nextY >= c) {
                for (int j = r; j <= nextX; j++) {
                    for (int k = c; k <= nextY; k++) {
                        sum += graph[j][k];
                    }
                }
            } else {
                for (int j = nextX; j <= r; j++) {
                    for (int k = nextY; k <= c; k++) {
                        sum += graph[j][k];
                    }
                }
            }
            max = Math.max(max, sum);
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
