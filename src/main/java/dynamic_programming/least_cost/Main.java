package dynamic_programming.least_cost;

import java.util.Arrays;

//1916
public class Main {

    static int nodeCount;
    static int lineCount;
    static int[][] costArr;
    static boolean[] visits;

    public static void main(String[] args) throws Exception {
        nodeCount = read();
        lineCount = read();
        costArr = new int[nodeCount][nodeCount];
        //비용초기화
        for (int i = 0; i < costArr.length; i++) {
            int[] ints = costArr[i];
            Arrays.fill(ints, Integer.MAX_VALUE);
            ints[i] = 0;
        }
        visits = new boolean[nodeCount];

        //비용설정
        for (int i = 0; i < lineCount; i++) {
            int start = read() - 1;
            int end = read() - 1;
            int cost = read();
            costArr[start][end] = Math.min(costArr[start][end], cost);
        }

        int startAtIndex = read() - 1;
        int endToIndex = read() - 1;
        visits[startAtIndex] = true;

        for (int i = 0; i < nodeCount - 1; i++) {
            int nextIndex = findUnvisitedMinNodeIndex(startAtIndex);
            if (nextIndex == nodeCount) continue;
            int[] nextNodeArr = costArr[nextIndex];
            for (int j = 0; j < nextNodeArr.length; j++) {
                if (nextNodeArr[j] == Integer.MAX_VALUE) continue;
                costArr[startAtIndex][j] = costArr[startAtIndex][j] == Integer.MAX_VALUE
                        ? costArr[startAtIndex][nextIndex] + nextNodeArr[j]
                        : Math.min(costArr[startAtIndex][j], costArr[startAtIndex][nextIndex] + nextNodeArr[j]);
            }
            visits[nextIndex] = true;
        }

        System.out.println(costArr[startAtIndex][endToIndex]);

    }

    private static int findUnvisitedMinNodeIndex(int nodeIndex) {
        int[] nodeIndexCostsArr = costArr[nodeIndex];
        int min = Integer.MAX_VALUE;
        int minIndex = nodeCount;
        for (int i = 0; i < nodeIndexCostsArr.length; i++) {
            if (visits[i]) continue;
            int now = nodeIndexCostsArr[i];
            if (now == Integer.MAX_VALUE) continue;
            if (Math.min(min, now) != min) {
                min = now;
                minIndex = i;
            }
        }
        return minIndex;
    }


    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
