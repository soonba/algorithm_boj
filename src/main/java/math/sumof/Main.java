package math.sumof;

public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        long total = 0;
        for (int i = 1; i <= n; i++) {
            total += (n/i) * i;
        }
        System.out.println(total);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
