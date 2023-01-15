package math.statistics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        List<Integer> numList = new ArrayList<>();
        int sum = 0;
        Map<Integer,Integer> modeMap = new HashMap<>();
        int medianIndex = T / 2;



        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            numList.add(num);
            sum += num;

            modeMap.merge(num, 1, Integer::sum);
        }

        List<Integer> modeMaxList = new ArrayList<>();
        int modeMax = -4000;
        for (Integer value : numList) {
            Integer integer = modeMap.get(value);
            if (modeMax == integer) {
                if (!modeMaxList.contains(value)) {
                    modeMaxList.add(value);
                }
            } else if (integer >= modeMax) {
                modeMax = integer;
                modeMaxList.clear();
                modeMaxList.add(value);
            }
        }
        Collections.sort(modeMaxList);
        Collections.sort(numList);

        int round = Math.round((float)sum / (float)T);
        System.out.println(round);
        System.out.println(numList.get(medianIndex));
        System.out.println(modeMaxList.size() == 1 ? modeMaxList.get(0) : modeMaxList.get(1));
        System.out.println(numList.get(numList.size()-1) - numList.get(0));


    }
}
