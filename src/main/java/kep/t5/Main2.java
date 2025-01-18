package kep.t5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    static boolean[] visited;
    static int[] costs;
    static Map<Integer, ArrayList<int[]>> graph = new HashMap();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        costs = new int[T];
        for(int i = 1; i < T; i++) {
            String[] arr = br.readLine().split(" ");
            int u = Integer.parseInt(arr[0]);
            int v = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);
            ArrayList<int[]> orDefault = graph.getOrDefault(u, new ArrayList<>());
            orDefault.add(new int[]{v,c});
            ArrayList<int[]> orDefault2 = graph.getOrDefault(v, new ArrayList<>());
            orDefault2.add(new int[]{u,c});
            graph.put(u, orDefault);
            graph.put(v, orDefault2);
        }

        for(int i = 0; i< T; i++) {
            visited = new boolean[T];
            int bfsCost = bfs(i);
            costs[i] = bfsCost;
        }

        int asInt = Arrays.stream(costs).min().getAsInt();
        System.out.println(asInt);
    }

    private static int bfs(int node) {
        Queue<int[]> q = new LinkedList<>();
        int cost = 0;
        q.add(new int[]{node, 0});
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowNode = now[0];
            int nowCost = now[1];
            visited[nowNode] = true;
            ArrayList<int[]> next = graph.get(nowNode);
            cost += nowCost;
            for (int[] aNext : next) {
                if(visited[aNext[0]]) continue;
                q.add(new int[]{ aNext[0], aNext[1] + nowCost});
            }
        }
        return cost;
    }
}
