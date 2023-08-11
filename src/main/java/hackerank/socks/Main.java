package hackerank.socks;

public class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        boolean[] color = new boolean[101];
        int count = 0;
        for (int i = 0; i < N; i++) {
            int next = read();
            if (color[next]) count++;
            color[next] = !color[next];
        }
        System.out.println(count);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
