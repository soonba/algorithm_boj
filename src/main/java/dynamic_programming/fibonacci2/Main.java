package dynamic_programming.fibonacci2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {
    static BigDecimal[] fibonacciArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        fibonacciArr = new BigDecimal[N + 1];
        fibonacciArr[0] = new BigDecimal(0);
        fibonacciArr[1] = new BigDecimal(1);

        for (int i = 2; i <= N; i++) {
            initFibonacci(i);
        }


        System.out.println(fibonacciArr[N]);

    }

    static void initFibonacci(int N) {
        fibonacciArr[N] = fibonacciArr[N - 1].add(fibonacciArr[N - 2]);
    }

}
