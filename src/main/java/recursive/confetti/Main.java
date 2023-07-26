package recursive.confetti;

public class Main {

    static int white = 0;
    static int blue = 0;
    static int[][] arr;
    public static void main(String[] args) throws Exception {

        int N = read();

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[j][i] = read();
            }
        }

        divideAndConcur(0,0,N-1,N-1);

        StringBuilder sb = new StringBuilder();
        sb.append(white).append("\n").append(blue);
        System.out.println(sb);

    }

    private static void divideAndConcur(int x0, int y0, int x1, int y1) {

        int temp = 0;
        int blueCount = (x1-x0 +1) * (x1-x0 +1);

        for (int i = x0; i <= x1; i++) {
            for (int j = y0; j <= y1 ; j++) {
                temp += arr[i][j];
            }
        }

        if(temp == 0) {
            white++;
            return;
        }
        if(temp == blueCount) {
            blue++;
            return;
        }

        divideAndConcur(x0  ,y0  ,(x0+x1)/2,(y0+y1)/2);
        divideAndConcur((x0+x1)/2+1, y0, x1,(y0+y1)/2);
        divideAndConcur(x0  ,(y0+y1)/2+1,(x0+x1)/2, y1);
        divideAndConcur((x0+x1)/2+1,(y0+y1)/2+1, x1, y1);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
