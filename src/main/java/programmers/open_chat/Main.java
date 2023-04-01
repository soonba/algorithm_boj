package programmers.open_chat;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] str = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        Solution solution = new Solution();
        String[] result = solution.solution(str);
        Arrays.stream(result).forEach(System.out::println);
    }
}
