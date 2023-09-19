package graph.move_pipe;

public class Main {
    static int count = 0;
    static int N;

    static int[][] house;

    public static void main(String[] args) throws Exception {
        N = read();
        house = new int[N+1][N+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                house[i+1][j+1] = read();
            }
        }

        //0 →
        //1 ↓
        //2 ↘︎
        // x => 열 y => 행 이동
        dfs(1,2,0);

        System.out.println(count);

    }

    private static void dfs(int x, int y, int direction) {
        if(x == N && y == N) {
            count++;
            return;
        }

        //아래
        if(x <= N-1 && direction != 0 && house[x+1][y] != 1) {
            dfs(x+1, y, 1);
        }

        //오른쪽
        if(y <= N-1 && direction != 1 && house[x][y+1] != 1) {
            dfs(x, y+1, 0);
        }

        //오른쪽 아래
        if(x <= N-1 && y <= N-1 && house[x+1][y+1] != 1 && house[x][y+1] != 1 && house[x+1][y] != 1) {
            dfs(x+1, y+1, 2);
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}