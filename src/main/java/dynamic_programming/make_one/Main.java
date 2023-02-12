package dynamic_programming.make_one;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1463
 * Level: Silver III
 * Algorithm: Dynamic Programming
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] DP = new int[N+1];
        DP[0] = DP[1] = 0;
        for (int i = 2; i <= N; i++) {
            DP[i] = DP[i-1] + 1;
            if(i % 2 == 0) DP[i] = Math.min(DP[i], DP[i/2] + 1);
            if(i % 3 == 0) DP[i] = Math.min(DP[i], DP[i/3] + 1);
        }
        System.out.println(DP[N]);

    }

}
