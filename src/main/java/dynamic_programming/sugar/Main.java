package dynamic_programming.sugar;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static final int MAX_COUNT = 5001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        int[] DP = new int[target+1];

        for (int i = 0; i <= target; i++) {
            if(i < 6) {
                DP[i] = (i == 3 || i == 5) ? 1 : MAX_COUNT;
                continue;
            }
            DP[i] = Math.min(DP[i-3]+1,DP[i-5]+1);
        }

        int result = DP[target] >= MAX_COUNT ? -1 : DP[target];
        System.out.println(result);
    }
}
