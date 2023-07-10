package math.new_avrg;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();

        double[] scores = new double[N];
        double max = 0.0;
        for (int i = 0; i < N; i++) {
            int read = read();
            scores[i] = read;
            max = Math.max(max, read);
        }

        for (int i = 0; i < N; i++) {
            double l = scores[i] / max;
            scores[i] = l*100;
        }

        System.out.println(Arrays.stream(scores).average().getAsDouble());
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
