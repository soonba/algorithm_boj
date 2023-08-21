package dynamic_programming.aTob;

public class Main {
    static int result = Integer.MAX_VALUE;
    static long B;
    public static void main(String[] args) throws Exception {

        int A = read();
        B = read();

        calc((long)A, 1);

        int print = result == Integer.MAX_VALUE ? -1 : result;
        System.out.println(print);
    }

    private static void calc(long a, int cnt) {
        if(a > B) return;
        if(a == B) {
            result = Math.min(result, cnt);
            return;
        }
        calc(a * 10 + 1, cnt + 1);
        calc( a * 2 , cnt + 1);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
