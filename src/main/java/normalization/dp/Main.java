package normalization.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        int[] W = new int[N+1];
        int[] V = new int[N+1];

        for(int i = 1; i <= N; i++) {
            String[] WN = br.readLine().split(" ");
            W[i] = Integer.parseInt(WN[0]);
            V[i] = Integer.parseInt(WN[1]);
        }

        int[][] DP = new int[N+1][K+1];

        for(int k = 1; k <= K; k++) {
            for(int n = 1; n <= N; n++) {
                if(k - W[n] < 0) {
                    DP[n][k] = DP[n-1][k];
                } else {
                    DP[n][k] = Math.max(DP[n-1][k], DP[n-1][k-W[n]] + V[n]);
                }
            }
        }

        System.out.println(DP[N][K]);

    }
}
