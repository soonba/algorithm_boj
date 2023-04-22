package programmers.parcel;

public class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        int delivery = 0, pickup = 0;
        long moveCount = 0;
        for (int i = n-1; i > -1 ; i--) {
            int cnt = 0;
            while(deliveries[i] > delivery || pickups[i] > pickup) {
                delivery += cap;
                pickup += cap;
                cnt++;
            }
            moveCount += 2L * cnt * (i+1);
            delivery -= deliveries[i];
            pickup -= pickups[i];
        }

        return moveCount;
    }
}

