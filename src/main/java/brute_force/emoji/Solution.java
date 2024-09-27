package brute_force.emoji;

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cheat = 0, cnt = 0;
        for (int now : lottos) {
            if (now == 0)
                cheat++;
            else if (contain(now, win_nums))
                cnt++;
        }
        int min = 7 - cnt;
        int max = min - cheat;
        return new int[]{max == 7 ? 6 : max, min == 7 ? 6 : min };
    }

    private boolean contain(int now, int[] win_nums) {
        for (int winNum : win_nums) {
            if (now == winNum)
                return true;
        }
        return false;
    }
}