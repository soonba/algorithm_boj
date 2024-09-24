package graph.most_present;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public int solution(String[] friends, String[] gifts) {
        int cnt = friends.length;
        int[][] ints = new int[cnt][cnt];
        int[] pIndex = new int[cnt];
        int[] results = new int[cnt];
        List<String> list = Arrays.asList(friends);
        Arrays.stream(gifts).forEach(gift -> {
            String[] aToB = gift.split(" ");
            int aIndex = list.indexOf(aToB[0]);
            int bIndex = list.indexOf(aToB[1]);
            ints[aIndex][bIndex]++;
            pIndex[aIndex]++; pIndex[bIndex]--;
        });
        for (int i = 0; i < cnt; i++) {
            for (int j = i+1; j < cnt; j++) {
                if(ints[i][j] > ints[j][i]) {
                    results[i]++;
                } else if(ints[i][j] < ints[j][i]) {
                    results[j]++;
                } else {
                    if(pIndex[i] > pIndex[j]) results[i]++;
                    if(pIndex[i] < pIndex[j]) results[j]++;
                }
            }
        }
        return Arrays.stream(results).max().getAsInt();
    }
}
