package bf.remote_controll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static final List<Integer> buttons = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer goal = (Integer) scanner.nextInt();
        int broken = scanner.nextInt();
        for (int i = 0; i < broken; i++) {
            int brokenNum = scanner.nextInt();
            buttons.remove((Integer) brokenNum);
        }
        Sol sol = new Sol();
        sol.sol(goal, buttons);
    }
}
