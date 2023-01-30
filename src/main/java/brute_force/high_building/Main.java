package brute_force.high_building;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static double[] buildings;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] B = br.readLine().split(" ");
        buildings = new double[T];
        for (int i = 0; i < T; i++) {
            buildings[i] = Double.parseDouble(B[i]);
        }

        List<Integer> visibleCount = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            //빌딩 하나 선택
            visibleCount.add(countVisible(i, buildings[i]));
        }

        System.out.println(Collections.max(visibleCount));
    }

    private static int countVisible(int x, double y) {
        int count = 0;
        int x1 = x;
        double y1 = y;
        for (int i = 0; i < buildings.length; i++) {
            //선을 이을 빌딩
            int x2 = i;
            double y2 = buildings[i];

            //같은 빌딩은 점프
            if (x1 == x2) {
                continue;
            }
            //방정식을 구하고 그 사이에서 걸리는 게 없는지 여부
            if (makeEquationAndIsVisible(x1, x2, y1, y2)) {
                count++;
            }
        }
        return count;
    }
    private static boolean makeEquationAndIsVisible(int x1, int x2, double y1, double y2) {
        double inclination = (y2 - y1) / (x2 - x1);
        //대상 빌딩이 왼쪽에 있는지 오른쪽에 있는지에 따라 분기처리
        return x1 < x2
                ? check(x1 + 1, x2, inclination, y1, x1)
                : check(x2 + 1, x1, inclination, y1, x1);
    }
    private static boolean check(int first, int second, double inclination, double yConstant, int x1) {
        for (int i = first; i < second; i++) {
            double y = inclination * (i - x1) + yConstant;
            if (y <= buildings[i]) {
                return false;
            }
        }
        return true;
    }
}