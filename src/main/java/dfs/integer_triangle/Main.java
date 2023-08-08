package dfs.integer_triangle;

public class Main {
    public static void main(String[] args) throws Exception {

        int T = read();
        int length = (T * (T + 1)) / 2;
        int[] DP = new int[length];
        int[] numbers = new int[length];
        int[] depth = new int[length];
        int depthN = 1;

        for (int i = 0; i < length; i++) {
            int next = read();
            numbers[i] = next;
            if(length-i <= T) {
                DP[i] = next;
            }

            if(i >= (depthN * (depthN + 1))/2) {
                depthN++;
            }
            depth[i] = depthN;
        }

        for (int i = length - T - 1; i >= 0 ; i--) {
            int depthCount = depth[i];
            DP[i] = numbers[i] + Math.max(DP[i+depthCount], DP[i+depthCount+1]);
        }

        System.out.println(DP[0]);
    }


    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
