package hackerank.dense_rank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        int[] rankArr = new int[ranked.size()];
        int rankCount = 1;
        rankArr[0] = rankCount;
        for (int i = 1; i < rankArr.length; i++) {
            Integer now = ranked.get(i);
            Integer prev = ranked.get(i - 1);
            rankArr[i] = now.equals(prev) ? rankCount : ++rankCount;
        }

        List<Integer> answerList = new ArrayList<>();
        int lastIndex = ranked.size() - 1;
        for (Integer playerScore : player) {
            int answer = 1;
            for (int j = lastIndex; j >= 0; j--) {
                Integer rankedScore = ranked.get(j);
                if (playerScore < rankedScore) {
                    answer = rankArr[j] + 1;
                    break;
                } else if (playerScore.equals(rankedScore)) {
                    answer = rankArr[j];
                    break;
                } else {
                    lastIndex--;
                }
            }
            answerList.add(answer);
        }
        return answerList;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] S = br.readLine().split(" ");
        List<Integer> ranked = new ArrayList<>();
        for (String s : S) {
            ranked.add(Integer.parseInt(s));
        }

        int T2 = Integer.parseInt(br.readLine());
        String[] S2 = br.readLine().split(" ");

        List<Integer> player = new ArrayList<>();
        for (String s : S2) {
            player.add(Integer.parseInt(s));
        }

        List<Integer> result = Result.climbingLeaderboard(ranked, player);
        for (int i = 0; i < result.size(); i++) {
//            System.out.print("i = " + i + "  :  ");
            System.out.println(result.get(i));
        }

    }
}

