package programmers.parcel;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long result = solution.solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0});
        System.out.println(result == 16);
        long result2 = solution.solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0});
        System.out.println(result2 == 30);
        long result3 = solution.solution(2, 2, new int[]{0, 0}, new int[]{0, 0});
        System.out.println(result3 == 0);
        long result4 = solution.solution(4, 4, new int[]{25, 24, 51, 0}, new int[]{51, 0, 0, 49});
        System.out.println(result4 == 140);
//        4, 4, [25, 24, 51, 0], [51, 0, 0, 49]
    }
}
