package boj.silver.B1004;

public class Main {
    public static void main(String[] args) throws Exception {
        int T = read();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int sX = read();
            int sY = read();
            int eX = read();
            int eY = read();
            int P = read();
            int count = 0;
            for (int j = 0; j < P; j++) {
                int x = read();
                int y = read();
                int r = read();
                boolean startIn = (sX - x) * (sX - x) + (sY - y) * (sY - y) < r * r;
                boolean endIn = (eX - x) * (eX - x) + (eY - y) * (eY - y) < r * r;
                if (startIn && !endIn) count++;
                if (endIn && !startIn) count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        boolean isMinus = false;

        int c, n = System.in.read();
        if (n == 45) {
            isMinus = true;
            n = System.in.read();
        }
        n &= 15;

        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);

        if (isMinus)
            return ~n + 1;
        else
            return n;
    }
}