package boj.gold;

public class B12865 {
    public static void main(String[] args) throws Exception {
        int N = read(); //물품
        int K = read(); //버티는 무게

        int[] W = new int[N+1]; //무게
        int[] V = new int[N+1]; //가치
        for (int i = 1; i <= N; i++) {
            W[i] = read();
            V[i] = read();
        }

        //N행 K+1열 2차원 DP 테이블 초기화
        int[][] DP = new int[N+1][K+1];

        for (int k = 1; k <= K; k++) {
            for (int i = 1; i <= N; i++) {
                if(k-W[i] < 0) {
                    DP[i][k] = DP[i - 1][k];
                } else {
                    DP[i][k] = Math.max(DP[i - 1][k], DP[i - 1][k - W[i]] + V[i]);
                }
            }
        }

        System.out.println(DP[N][K]);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
