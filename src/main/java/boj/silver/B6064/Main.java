package boj.silver.B6064;

public class Main {
    public static void main(String[] args) throws Exception {
        int T = read();

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            int M = read(), N = read(), x = read(), y = read();

            int lcm = M * N / gcd(M, N);
            int n = 0;
            int result = -1;
            while (n * M < lcm) {
                if ((n * M + x - y) % N == 0) {
                    result = n * M + x;
                    break;
                }
                n++;
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    static int gcd(int n1, int n2) {
        if (n2 == 0)
            return n1;
        return gcd(n2, n1 % n2);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}