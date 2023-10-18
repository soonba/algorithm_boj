package boj.silver.B2579;

public class Main {
    public static void main(String[] args) throws Exception {
        int t = read();
        int[] DP = new int[t];
        int[] score = new int[t];
        for (int i = 0; i < t; i++) {
            score[i] = read();
        }
        DP[0] = score[0];
        if(t >= 2) DP[1] = score[1] + score[0];
        if(t >= 3) DP[2] = Math.max(score[1],score[0]) + score[2];
        if(t > 3) {
            for (int i = 3; i < t; i++) {
                DP[i] = Math.max(DP[i-3] + score[i-1], DP[i-2]) + score[i];
            }
        }
        System.out.println(DP[t-1]);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
