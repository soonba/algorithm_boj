package dynamic_programming.coin0;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        int coinCnt = read();
        int goal = read();

        List<Integer> coinList = new ArrayList<>();
        for (int i = 0; i < coinCnt; i++) {
            coinList.add(read());
        }

        int[] DP = new int[goal + 1];
        for (int i = 0; i < DP.length; i++) {
            DP[i] = i;
        }

        for (int i = 1; i < coinList.size(); i++) {
            Integer coin = coinList.get(i);
            for (int j = coin; j < DP.length; j++) {
                DP[j] = Math.min(DP[j], DP[j - coin] + 1);
            }
        }

        System.out.println(DP[goal]);


    }


    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}