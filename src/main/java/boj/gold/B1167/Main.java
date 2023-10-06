package boj.gold.B1167;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//모든 정점은 cycle이 없음
//두 정점간 경로는 항상 유일
//길이가 가장 긴 정점 2개 중 하나는 어떤 정점의 가장 긴 정점이다.
//즉 임의의 정점에서 가장 먼 정점을 찾으면, 그 정점은 2개 중 하나가 될 것이고
//다시 그 정점에서 가장 먼 정점을 구하면 답이 나온다.
//입력값을 받는다.
//ArrayList<>[] 초기화.
//5
//1 3 2 -1
//2 4 4 -1
//3 1 2 4 3 -1
//4 2 4 3 3 5 6 -1
//5 4 6 -1
//예제 출력 1
//11

public class Main {
    static List<Node>[] graph;
    static boolean[] visited;
    static int max;
    static int maxIndex;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        graph = new ArrayList[V+1];
        visited = new boolean[V+1];
        max = 0;
        maxIndex = V+2;

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            String s = br.readLine();
            String[] split = s.split(" ");
            int j = 1;
            int index = Integer.parseInt(split[0]);
            while(!split[j].equals("-1")) {
                int destination = Integer.parseInt(split[j++]);
                int distance = Integer.parseInt(split[j++]);
                graph[index].add(new Node(destination,distance));
            }
        }

        dfs(2,0);
        int fstDFSMaxIndex = maxIndex;
        visited = new boolean[V+1];
        max = 0;
        maxIndex = V+2;
        dfs(fstDFSMaxIndex, 0);

        System.out.println(max);
    }

    private static void dfs(int index, int distance) {
        if(visited[index]) {
            return;
        }

        visited[index] = true;
        max = Math.max(max,distance);
        if(max == distance) {
            maxIndex = index;
        }
        List<Node> now = graph[index];
        for (int i = 0; i < now.size(); i++) {
            Node nodee = now.get(i);
            dfs(nodee.getIndex(), distance + nodee.getDistance());
        }
    }

}
class Node {
    private final int index;
    private final int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }
}
