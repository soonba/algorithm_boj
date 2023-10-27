package boj.silver.B11053;

//6
//10 20 10 30 20 50
public class Main {
    public static void main(String[] args) throws Exception {
        int t = read();
        int[] s = new int[t];
        int[] l = new int[t];
        int max = 0;
        for (int i = 0; i < t; i++) {
            s[i] = read();

            for (int j = 0; j < i; j++) {
                if(s[i] > s[j]) {
                    l[i] = Math.max(l[i], l[j]+1);
                }
            }
            max = Math.max(l[i],max);
        }
        System.out.println(max+1);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
