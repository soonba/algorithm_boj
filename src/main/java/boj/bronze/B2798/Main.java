package boj.bronze.B2798;

public class Main {
    public static void main(String[] args) throws Exception {
        int tc = read();
        int g = read();
        int[] arr= new int[tc];
        for (int i = 0; i < tc; i++) {
            arr[i] = read();
        }

        int max = 0;

        for (int i = 0; i < tc; i++) {
            for (int j = i+1; j < tc; j++) {
                for (int k = j+1; k < tc; k++) {
                    int calc = arr[i] + arr[j] + arr[k];
                    if(calc>g) continue;
                    max = Math.max(max,calc);
                }
            }
        }
        System.out.println(max);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
