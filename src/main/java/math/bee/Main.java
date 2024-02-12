package math.bee;

public class Main {
    public static void main(String[] args) throws Exception {
        int r = read();
        int s = 1, c = 0;
        while(s < r) s += ++c * 6;
        System.out.println(c+1);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
