package normalization.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
//        knapsack();
//        GCD();
        RGB();
    }

    private static void RGB() throws Exception {
//3
//26 40 83
//49 60 57
//13 89 99
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] R = new int[T+1];
        int[] G = new int[T+1];
        int[] B = new int[T+1];

        for (int i = 1; i <= T; i++) {
            String[] split = br.readLine().split(" ");
            R[i] = Integer.parseInt(split[0]);
            G[i] = Integer.parseInt(split[1]);
            B[i] = Integer.parseInt(split[2]);
        }
        int[] DPR = new int[T+1];
        int[] DPG = new int[T+1];
        int[] DPB = new int[T+1];
        DPR[1] = R[1]; DPG[1] = G[1]; DPB[1] = B[1];
        for (int i = 2; i <= T; i++) {
            DPR[i] = Math.min(DPB[i-1], DPG[i-1]) + R[i];
            DPG[i] = Math.min(DPB[i-1], DPR[i-1]) + G[i];
            DPB[i] = Math.min(DPR[i-1], DPG[i-1]) + B[i];
        }
        int min = Math.min(Math.min(DPR[T], DPB[T]), DPG[T]);
        System.out.println(min);
    }

    private static void GCD() {
        int a = 1837128300; int b = 778742874;
        int answer = gcd(a, b);
        System.out.println(answer);
    }

    private static int gcd(int a, int b ) {
        if(b ==0) {
            return a;
        }
        return gcd(b, a % b) ;
    }

    private static void knapsack() throws Exception {
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
