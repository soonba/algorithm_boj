package pstmt.z;

public class Main {
    static int N, r, c;
    static int rs, re, cs, ce;
    static int score = 0;

    public static void main(String[] args) throws Exception {
        N = read();
        r = read();
        c = read();
        rs = 0;
        re = _2pow(N) - 1;
        cs = 0;
        ce = _2pow(N) - 1;
        z(N);
        System.out.println(score);
    }

    static int _2pow(int N) {
        int score = 1;
        for (int i = 0; i < N; i++) {
            score *= 2;
        }
        return score;
    }

    static void z(int N) {
        if (N == 0) return;
        int adjust = _2pow(N - 1) * _2pow(N - 1);
        int r_bound = (rs + re) / 2;
        int c_bound = (cs + ce) / 2;
        int quadrant;
        if (r > r_bound) {
            if (c > c_bound) {
                quadrant = 3;
                rs = r_bound + 1;
                cs = c_bound + 1;
            } else {
                quadrant = 2;
                rs = r_bound + 1;
                ce = c_bound;
            }
        } else {
            if (c > c_bound) {
                quadrant = 1;
                re = r_bound;
                cs = c_bound + 1;
            } else {
                quadrant = 0;
                re = r_bound;
                ce = c_bound;
            }
        }
        score += adjust * quadrant;
        z(N - 1);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
