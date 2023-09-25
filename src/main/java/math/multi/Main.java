package math.multi;

public class Main {
    static long C;
    public static void main(String[] args) throws Exception {
        long A = read();
        long B = read();
        C = read();

        long recursive = recursive(A, B);
        System.out.println(recursive);
    }

    private static long recursive(long a, long b) {
        if(b==1) {
            return a;
        }

        long temp = recursive(a, b / 2);
        if(b % 2 == 1) {
            temp = (temp * (a%C)) % C;
        }
        return temp;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
