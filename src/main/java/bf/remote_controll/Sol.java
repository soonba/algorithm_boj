package bf.remote_controll;

import java.util.List;
import java.util.Objects;

import static java.lang.Math.abs;

public class Sol {
    private int targetN;
    private String numSTR;
    private boolean minFromDFS = false;

    public Integer sol(Integer goal, List<Integer> buttons) {

        int init = abs(goal - 100);
        targetN = init;
        dfs(0, "", goal, buttons);
        int i;
        int count = targetN;
        if (minFromDFS) {
            i = (Integer) Integer.parseInt(numSTR);
        } else {
            count = init;
            i = 100;
        }

        System.out.println(count);
//        System.out.println("method Loop Count = " + methodLoopCounter);
        return i;


    }

    // e.g 1,4,5 7234 cnt = 4
    // n = n번째 숫자
    // cnt = 최대 버튼길이
    private void dfs(int cnt, String prev, Integer goal, List<Integer> buttons) {
        int goalLen = goal.toString().length();

        if (goalLen + 2 == cnt) {
            return;
        }
        if (abs(goalLen - cnt) < 2 && !Objects.equals(prev, "")) {
            Integer prevInt = Integer.parseInt(prev);
            int abs = abs(goal - prevInt);
            int length = prevInt.toString().length();
            targetN = Math.min(targetN, abs + length);
            if (targetN == abs + length) {
                numSTR = prev;
                minFromDFS = true;
            }
        }

        for (Integer button : buttons) {
            if (goalLen + 2 == cnt + 1) {
                continue;
            }
            dfs(cnt + 1, prev + button.toString(), goal, buttons);
        }
    }
}