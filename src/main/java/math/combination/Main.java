package math.combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11050
 * Level: 브론즈 1
 * Algorithm: Math
 */

/*
노드를 초기화해주고 정렬한다. 단방향 인접 리스트로 구현
nxn 행렬의 '모든 점'에 대해 bfs 를 수행한다.
결과를 출력한다.
*/
public class Main {
    static final int MAXIMUM_N = 10;
    static final int[] factorialArr = new int[MAXIMUM_N+1];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int nF = factorial(n);
        int kF = factorial(k);
        int nkF = factorial(n - k);
        System.out.println(combination(nF, kF, nkF));
    }

    private static int combination(int nF, int kF, int nkF) {
        return nF / (kF * nkF);
    }

    private static int factorial(int n) {
        if(factorialArr[n] != 0) return factorialArr[n];
        if(n==0) {
            factorialArr[0] = 1;
            return 1;
        }
        if(n<=2) {
            factorialArr[n] = n;
            return n;
        }
        int temp = 1;
        for (int i = 2; i <= n; i++) {
            temp *= i;
            factorialArr[i] = temp;
        }
        return temp;
    }
}
