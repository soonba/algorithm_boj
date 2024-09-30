package dfs.two_q;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long q1Sum = Arrays.stream(queue1).sum();
        long q2Sum = Arrays.stream(queue2).sum();
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            q1.add((long)queue1[i]);
            q2.add((long)queue2[i]);
        }
        
        int len = queue1.length;
        int count = 0;
        while(count++ < 3 * len ) {
            if(q1Sum > q2Sum) {
                if(q1.isEmpty()) break;
                Long target = q1.poll();
                q2.add(target);
                q1Sum -= target;
                q2Sum += target;
            } else if(q1Sum < q2Sum) {
                if(q2.isEmpty()) break;
                Long target = q2.poll();
                q1.add(target);
                q2Sum -= target;
                q1Sum += target;
            } else {
                return count -1;
            }
        }
        return - 1;
    }
}
