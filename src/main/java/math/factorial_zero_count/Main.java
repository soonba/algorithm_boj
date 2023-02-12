package math.factorial_zero_count;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1676
 * Level: Silver V
 * Algorithm: Math
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        double num = 1;
        int count = 0;
        for (int i = 1; i <= N; i++) {
            num *= i;
            while (num % 10 == 0) {
                num /= 10;
                count++;
            }
            num = num % 1000;
        }

        System.out.println(count);
    }

}
