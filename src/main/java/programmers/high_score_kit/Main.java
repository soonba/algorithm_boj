package programmers.high_score_kit;

import programmers.high_score_kit.hash.be.Solution;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
//        System.out.println(solution1);
        for (int j : solution1) {
            System.out.println(j);
        }
    }
}
