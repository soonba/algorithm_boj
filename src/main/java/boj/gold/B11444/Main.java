package boj.gold.B11444;

public class Main {
    public static void main(String[] args) throws Exception {
        long[] fibo = {0,1};
        int r = read();

        for (int i = 2; i < r; i++) {
            fibo[i%2] = (fibo[0] + fibo[1]) % 1000000007;
            System.out.println("fibo["+i+"] = "+ fibo[i%2]);
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
