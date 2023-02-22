package brute_force.paint_comparison;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        List<Paint> paintList = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 5; j++) {
                sb.append(br.readLine());
            }
            String[] split = sb.toString().split("");
            paintList.add(new Paint(split));
        }

        int minComparison = Integer.MAX_VALUE;
        String result = "";

        for (int i = 0; i < paintList.size(); i++) {
            for (int j = 0; j < paintList.size(); j++) {
                if(i>=j) continue;
                int comparison = comparison(paintList.get(i), paintList.get(j));

                minComparison = Math.min(minComparison,comparison);
                if(minComparison == comparison) {
                    result = (i+1) + " " + (j+1);
                }
            }
        }

        System.out.println(result);
    }


    static int comparison(Paint p1, Paint p2) {
        int count = 0;
        for (int i = 0; i < p1.value.length; i++) {
            if(!p1.value[i].equals(p2.value[i])) count++;
        }
        return count;
    }

    static class Paint {
        String[] value;

        public Paint(String[] value) {
            this.value = value;
        }
    }
}
