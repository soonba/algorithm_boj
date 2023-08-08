package math.n2tile;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] DP = new int[1001];
        int n = read();

        DP[0] = 1;
        DP[1] = 2;

        for (int i = 2; i < n; i++) {
            DP[i] = (DP[i-1] + DP[i-2]) % 10007 ;
        }

        System.out.println(DP[n-1]);

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
