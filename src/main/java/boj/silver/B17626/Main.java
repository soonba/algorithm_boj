package boj.silver.B17626;

public class Main {
    static int min = 5;
    static int max;
    static int n;

    public static void main(String[] args) throws Exception {
        n = read();
        max = (int) Math.floor(Math.sqrt(n));
        dfs(0, 0, 0);
        System.out.println(min);
    }

    private static void dfs(int now, int count, int sum) {
        int nowPow = now * now;
        if (sum + nowPow == n) {
            min = count;
            return;
        }
        if (count + 1 >= min) return;
        for (int j = 1; j <= max; j++) {
            if (sum + j * j > n) return;
            dfs(j,count+1, sum + nowPow);
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
