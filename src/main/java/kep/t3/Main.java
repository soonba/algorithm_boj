package kep.t3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int T = Integer.parseInt(input);
        for(int i = 0; i < T; i++) {
            count(br.readLine());
        }
    }

    public static void count(String str) {
        String[] NM = str.split(" ");
        long N = Long.parseLong(NM[0]);
        long M = Long.parseLong(NM[1]);
        long nMax = N/5;
        long mMax = M/7;
        long nmMax = Math.min(nMax, mMax);
        long nRest = nMax - (nmMax * 5);
        long mRest = mMax - (nmMax * 7);

        if(nRest < 5) {
            System.out.println(nmMax);
        } else {
            long rest = (nRest + mRest) / 12;
            System.out.println(nmMax + rest);
        }

    }
}
