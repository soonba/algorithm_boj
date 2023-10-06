package boj.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1629 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] split = s.split(" ");

        long A = Integer.parseInt(split[0]);
        long B = Integer.parseInt(split[1]);
        long C = Integer.parseInt(split[2]);
//        A^B % C. (A * A') % C = (A%C * A'%C) % C

        long result = calc(A,B,C);

        System.out.println(result);

    }

    private static long calc(long A, long B, long C) {
        if(B==1) {
            return A % C;
        }

        if(B%2 == 0) {
            long temp = calc(A, B / 2, C);
            return (temp * temp) % C;
        } else {
            return ((calc(A,B-1,C)) * (A % C)) % C;
        }
    }
}
