package boj.gold.B1967;


import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Node>[] graph;
    static int max = 0;
    static int maxIdx = 0;
    static boolean[] visits;
    public static void main(String[] args) throws Exception {
        int N = read();
        graph  = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            int start = read() - 1;
            int end = read() - 1;
            int distance = read();
            graph[start].add(new Node(end,distance));
            graph[end].add(new Node(start, distance));
        }

        visits = new boolean[N];
        dfs(0, 0);
        visits = new boolean[N];
        dfs(maxIdx, 0);
        System.out.println(max);
    }

    private static void dfs(int now, int temp) {
        List<Node> nodes = graph[now];
        visits[now] = true;
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            if(visits[node.getIndex()]) {
                max = Math.max(max, temp);
                if(temp == max) {
                    maxIdx = now;
                }
                continue;
            }
            dfs(node.getIndex(),temp + node.getDistance());
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
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