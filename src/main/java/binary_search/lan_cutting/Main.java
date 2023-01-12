package binary_search.lan_cutting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Double T = Double.parseDouble(st.nextToken());
        Double cableCount = Double.parseDouble(st.nextToken());

        List<Double> cableList = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            cableList.add(Double.parseDouble(br.readLine()));
        }

        List<Integer> correctList = new ArrayList<>(List.of(0));

        double min = 1;
        double max = Collections.max(cableList);

        while (max - min > 1) {
            double mid = Math.floor((max + min) / 2);
            double count = getCount(cableList, mid);
            if (count >= cableCount) {
                correctList.add((int) mid);
                min = mid;
            } else {
                max = mid;
            }
        }

        if ((int) getCount(cableList, min) == cableCount) {
            correctList.add((int) min);
        }
        if ((int) getCount(cableList, min + 1) == cableCount) {
            correctList.add((int) min + 1);
        }


        System.out.println(Collections.max(correctList));

    }

    private static double getCount(List<Double> cableList, double target) {
        return cableList.stream().mapToDouble(obj -> Math.floor(obj / target)).sum();
    }
}
