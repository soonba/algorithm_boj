package dynamic_programming.minimum_cost;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    static int[] ends;
    static int[] costs;
    static int N;
    static int minCost = Integer.MAX_VALUE;
    static LinkedList<Integer>[] nodesList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ends = new int[M];
        costs = new int[M];
        nodesList  = new LinkedList[N];
        for (int i = 0; i < M; i++) {
            String[] S = br.readLine().split(" ");
            int start = Integer.parseInt(S[0])-1;
            int end = Integer.parseInt(S[1])-1;
            int cost = Integer.parseInt(S[2]);
            if (nodesList[start] == null) {
                nodesList[start] = new LinkedList<>();
            }
            nodesList[start].add(i);
            ends[i] = end;
            costs[i] = cost;
        }
        String[] S = br.readLine().split(" ");
        int sp = Integer.parseInt(S[0])-1;
        int ep = Integer.parseInt(S[1])-1;
        dfs(sp, ep, 0, new boolean[N]);
        System.out.println(minCost);
    }

    private static void dfs(int now, int ep, int sumCost, boolean[] visits) {
        if(now == ep) {
            //계산
            minCost = Math.min(minCost, sumCost);
            return;
        }

        LinkedList<Integer> nodes = nodesList[now];
        visits[now] = true;
        for (Integer nodeIndex : nodes) {
            int next = ends[nodeIndex];
            if(visits[next]) continue;
            int nextCost = sumCost + costs[nodeIndex];
            boolean[] nextBoolean = Arrays.copyOf(visits,N);
            dfs(next, ep, nextCost, nextBoolean);
        }
    }
}
