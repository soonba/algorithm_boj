package dynamic_programming.rgb_distance;

public class Main {

    public static void main(String[] args) throws Exception {
        int T = read();
        int[][] houses = new int[T][3];

        for (int i = 0; i < T; i++) {
            houses[i][0] = read(); //R
            houses[i][1] = read(); //G
            houses[i][2] = read(); //B
        }

        for (int i = 1; i < T; i++) {
            houses[i][0] = houses[i][0] + Math.min(houses[i-1][1], houses[i-1][2]);
            houses[i][1] = houses[i][1] + Math.min(houses[i-1][0], houses[i-1][2]);
            houses[i][2] = houses[i][2] + Math.min(houses[i-1][0], houses[i-1][1]);
        }

        System.out.println(Math.min(Math.min(houses[T-1][0],houses[T-1][1]),houses[T-1][2]));

    }


    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}