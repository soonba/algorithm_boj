package dynamic_programming.z;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1074
 * Level:
 * Algorithm:
*/

public class Main {
    static int N;
    static int r;
    static int c;
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        r = Integer.parseInt(s[1])+1;
        c = Integer.parseInt(s[2])+1;

        while(N >= 2) {
            quadrant();
        }
        // -3 은 0,0 보정 수, r보정 수 c 보정수
        count += (r*2) +c -3;
        System.out.println(count);

    }

    private static void quadrant() {
        double pow = Math.pow(2, N);
        double boundary = pow / 2;
        if(r > boundary && c > boundary) {
            r -= boundary;
            c -= boundary;
            count += 3 * Math.pow(4,N-1);
        } else if (r > boundary) {
            r -= boundary;
            count += 2 * Math.pow(4,N-1);
        } else if (c > boundary) {
            c -= boundary;
            count += 1 * Math.pow(4,N-1);
        }
        N--;
    }
}
