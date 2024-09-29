package data_structure.parking;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        for (int i = 0; i < solution1.length; i++) {
            System.out.println(solution1[i]);
        }
    }

}
