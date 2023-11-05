package boj.silver.B2805;

public class Main {
    public static void main(String[] args) throws Exception {
        int tc = read();   //개수
        int g = read();   //목표

        long min = 0, max = 0;
        int[] tree = new int[tc];
        for (int i = 0; i < tc; i++) {
            tree[i] = read();
            max = Math.max(max, tree[i]);
        }
        while(min<max) {
            long temp = (max+min)/2;
            long sum = 0;
            for (int t : tree) {
                if(t-temp<=0) continue;
                sum += t-temp;
            }

            if(sum < g) {
                max = temp;
            }
            else {
                min = temp+1;
            }
        }
        System.out.println(min-1);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
