package programmers.two_queue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1});
        int solution2 = solution.solution(new int[]{1, 2, 1, 2}, new int[]{1,10,1,2});
        int solution3 = solution.solution(new int[]{1,1}, new int[]{1,5});
        int solution4 = solution.solution(new int[]{1,1,1,8,10,9}, new int[]{1,1,1,1,1,1});
        System.out.println(solution1);
        System.out.println(solution2);
        System.out.println(solution3);
        System.out.println(solution4);
    }
}
