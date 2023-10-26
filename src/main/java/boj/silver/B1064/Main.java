package boj.silver.B1064;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(process());
    }

    private static double process() throws Exception {
        double x1 = read();
        double y1 = read();
        double x2 = read();
        double y2 = read();
        double x3 = read();
        double y3 = read();

        double d1 = (y3 - y1) * (x2 - x1);
        double d2 = (y2 - y1) * (x3 - x1);
        if ( (d1 == d2)) return -1;
        double a = getDistance(x1, y1, x2, y2);
        double b = getDistance(x1, y1, x3, y3);
        double c = getDistance(x2, y2, x3, y3);
        double max = Math.max(2*(a+b), Math.max(2*(b+c), 2*(c+a)));
        double min = Math.min(2*(a+b), Math.min(2*(b+c), 2*(c+a)));
        return max-min;
    }

    private static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    private static int read() throws Exception
    {
        boolean isMinus = false;

        int c, n = System.in.read();
        if(n == 45)
        {
            isMinus = true;
            n = System.in.read();
        }
        n &= 15;

        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);

        if(isMinus)
            return ~n + 1;
        else
            return n;
    }
}