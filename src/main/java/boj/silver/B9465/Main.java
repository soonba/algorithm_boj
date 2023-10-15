package boj.silver.B9465;

public class Main {

    public static void main(String[] args) throws Exception {
        int T = read();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = read();
            int[] DPU = new int[N];
            int[] DPD = new int[N];

            for (int j = 0; j < N; j++) {
                DPU[j] = read();
            }
            for (int j = 0; j < N; j++) {
                DPD[j] = read();
            }

            if(N==1) {
                sb.append(Math.max(DPU[0], DPD[0])).append("\n");
                continue;
            }
            DPU[1] = DPU[1] + DPD[0];
            DPD[1] = DPD[1] + DPU[0];
            for (int j = 2; j < N; j++) {
                DPU[j] = Math.max(DPU[j] + DPD[j-2], DPU[j] + DPD[j-1]);
                DPD[j] = Math.max(DPD[j] + DPU[j-2], DPD[j] + DPU[j-1]);
            }
            sb.append(Math.max(DPU[N-1], DPD[N-1])).append("\n");
        }

        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}

