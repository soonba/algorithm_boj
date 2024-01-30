package programmers.high_score_kit.dp.trag;

public class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        for (int i = 1; i < triangle.length; i++) {
            int[] nowLine = triangle[i];
            for (int j = 0; j < nowLine.length; j++) {
                int nowScore = nowLine[j];
                int left = j - 1 < 0 ? 0 : triangle[i - 1][j - 1];
                int right = j == triangle[i - 1].length ? 0 : triangle[i - 1][j];
                triangle[i][j] = Math.max(left, right) + nowScore;
                if(i == triangle.length-1) {
                    answer = Math.max(answer, triangle[i][j]);
                }
            }

        }
        return answer;
    }
}
