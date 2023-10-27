package boj.silver.B9461;

public class Main {
    public static void main(String[] args) throws Exception {
        int T = read();
        int[] a = new int[T];

        int max = 5;
        for (int i = 0; i < T; i++) {
            int r = read();
            max = Math.max(max, r);
            a[i] = r;
        }

        long[] P = new long[max];
        P[0] = 1;
        P[1] = 1;
        P[2] = 1;
        P[3] = 2;
        P[4] = 2;

        for (int i = 5; i < max; i++) {
            P[i] = P[i - 1] + P[i - 5];
        }

        StringBuilder sb = new StringBuilder();
        for (int j : a) {
            sb.append(P[j - 1]).append("\n");
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
