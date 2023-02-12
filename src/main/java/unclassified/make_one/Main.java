package unclassified.make_one;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

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
//        Arrays.fill(DP, N);
//        DP[0] = 0;
//        DP[1] = 1;
        for (int i = 0; i < DP.length; i++) {
            DP[i] = i;
        }
        for (int i = 2; i <=3; i++) {
            for (int j = 1; j < N+1; j++) {
                if(j < i || (DP[j] % i != 0)) {
                    continue;
                }
                DP[j] = Math.min(DP[j], (DP[j]/i));
            }
        }

        System.out.println(DP[N]);

    }

}
