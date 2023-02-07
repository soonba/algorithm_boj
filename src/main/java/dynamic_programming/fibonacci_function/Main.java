package dynamic_programming.fibonacci_function;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] fibo = new int[40];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i < 41; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }

        for (int i = 0; i < T; i++) {
            int target = Integer.parseInt(br.readLine());
            if(target == 0) {
                System.out.println("1 0");
            } else {
                System.out.println(fibo[target-1]+" "+fibo[target]);
            }
        }
    }
}
