package dynamic_programming.one_two_three;

public class Main {
    public static void main(String[] args) throws Exception{
        int T = read();

        int[] DP = new int[12];
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;

        for (int i = 4; i < 12; i++) {
            DP[i] = DP[i-1] + DP[i-2] + DP[i-3];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int read = read();
            sb.append(DP[read]).append("\n");
        }

        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}

