package programmers.privacy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] solution1 = solution.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
//        int[] solution1 = solution.solution("2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"});
//        int[] solution1 = solution.solution("2010.06.17", new String[]{"A 16"}, new String[]{"2009.01.19 A", "2000.01.05 A"});
        int[] solution1 = solution.solution("2021.12.08", new String[]{"A 18"}, new String[]{"2020.06.08 A"});
        for (int j : solution1) {
            System.out.println(j);
        }
    }
}

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] split = term.split(" ");
            termsMap.put(split[0], Integer.parseInt(split[1]));
        }
        List<Integer> result = new ArrayList<>();

        String[] split = today.split("\\.");
        Integer todayYear = Integer.parseInt(split[0]);
        Integer todayMonth = Integer.parseInt(split[1]);
        Integer todayDate = Integer.parseInt(split[2]);
        for (int i = 0; i < privacies.length; i++) {
            if(!isValid(todayYear,todayMonth,todayDate,privacies[i],termsMap)) {
                result.add(i+1);
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }

    private boolean isValid(Integer todayYear,Integer todayMonth, Integer todayDate, String privacy, Map<String, Integer> termsMap) {

        String[] split1 = privacy.split(" ");
        String day = split1[0];
        String privacyName = split1[1];
        Integer addMonth = termsMap.get(privacyName);


        String[] split2 = day.split("\\.");
        Integer targetYear = Integer.parseInt(split2[0]);
        Integer targetMonth = Integer.parseInt(split2[1]);
        Integer targetDate = Integer.parseInt(split2[2]);

        int addedMonth = targetMonth + addMonth;
        if(addedMonth > 12) {
            int addYear = addedMonth / 12;
            if(addedMonth % 12 == 0) {
                targetYear = targetYear + addYear-1;
                targetMonth = 12;
            } else {
                targetYear = targetYear + addYear;
                targetMonth = addedMonth - (12 * addYear);
            }
        } else {
            targetMonth = addedMonth;
        }

        if(targetDate == 1) {
            if(--targetMonth == 0) {
                targetYear--;
                targetMonth = 12;
            }
            targetDate = 28;
        } else {
            targetDate --;
        }

        if(targetYear.equals(todayYear)) {
            if(targetMonth.equals(todayMonth)) {
                return targetDate >= todayDate;
            }
            return targetMonth > todayMonth;
        }
        return targetYear > todayYear;
    }
}
