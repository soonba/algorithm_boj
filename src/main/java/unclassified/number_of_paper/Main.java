package unclassified.number_of_paper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int minusOne = 0;
    static int zero = 0;
    static int one = 0;

    static int[][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        matrix = new int[T][T];
        for (int i = 0; i < T; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(s, 0, matrix[i], 0, T);
        }
        calculate(0, 0, T);

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }

    private static void calculate(int row, int col, int size) {
        if (isOnePoint(size) || isAllSameNumber(row, col, size)) {
            increase(matrix[row][col]);
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int newSize = size / 3;
                int xWeight = i * newSize;
                int yWeight = j * newSize;
                calculate(row + xWeight, col + yWeight, newSize);
            }
        }
    }

    private static boolean isOnePoint(int size) {
        return size == 1;
    }

    private static void increase(int target) {
        if (target == -1) minusOne++;
        if (target == 0) zero++;
        if (target == 1) one++;
    }

    private static boolean isAllSameNumber(int row, int col, int size) {
        int first = matrix[row][col];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (first != matrix[i + row][j + col]) return false;
            }
        }
        return true;
    }
}
