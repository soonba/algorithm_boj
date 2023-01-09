package unclassified.lan_cutting;

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

        List<Integer> cableList = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            cableList.add(Integer.parseInt(br.readLine()));
        }

        int now = 0;
        int count = Collections.max(cableList);
        while(count >= cableCount) {
            now++;
            int temp = 0;
            for (Integer cable : cableList) {
                int countOne = cable / now;
                temp += countOne;
            }
            count = temp;
        }
        now = now == 0 ? 0 : now-1;
        System.out.println(now);
    }
}
