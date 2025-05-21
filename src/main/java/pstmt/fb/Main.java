package pstmt.fb;

public class Main {
    public static void main(String[] args) throws Exception {
        int[][] dp = new int[41][2];
        dp[0] = new int[]{1, 0};
        dp[1] = new int[]{0, 1};
        for (int i = 2; i < 41; i++) {
            dp[i] = new int[]{dp[i-1][0] + dp[i-2][0], dp[i-1][1] + dp[i-2][1]};
        }
        int T = read();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int now = read();
            sb.append(dp[now][0]).append(" ").append(dp[now][1]).append("\n");
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
