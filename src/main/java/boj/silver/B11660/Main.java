package boj.silver.B11660;

public class Main {
    public static void main(String[] args) throws Exception {
        int N = read(); // ~ 1,000
        int M = read(); // ~ 100,000

        int[][] DP = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                DP[i][j] = read() + DP[i][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int x1 = read();
            int y1 = read();
            int x2 = read();
            int y2 = read();

            int sum = 0;
            for (int j = x1; j <= x2; j++) {
                sum += DP[j][y2] - DP[j][y1-1];
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
