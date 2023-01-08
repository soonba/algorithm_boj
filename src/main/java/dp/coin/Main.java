package dp.coin;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int coinCount = scanner.nextInt();
        int targetNum = scanner.nextInt();
        List<Integer> coins = new ArrayList<>();
        int[] DP = new int[10001];
        Arrays.fill(DP, 10001);
        DP[0] = 0;
        for (int i = 0; i < coinCount; i++) {
            int coin = scanner.nextInt();
            coins.add(coin);
        }
        Collections.sort(coins);

        for (int i = 0; i < coins.size(); i++) {
            Integer coin = coins.get(i);
            for (int j = coin; j <= targetNum; j++) {
                DP[j] = Math.min(DP[j - coin] + 1, DP[j]);
            }
        }
        System.out.println(DP[targetNum] == 10001 ? -1 : DP[targetNum]);
    }
}


