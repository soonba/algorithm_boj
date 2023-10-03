package boj.gold;

import java.util.*;

//다익스트라 우선순위 큐
public class B1753 {
    public static void main(String[] args) throws Exception {
        int node = read();
        int line = read();
        int begin = read()-1;

        int[] costs = new int[node];
        Arrays.fill(costs,Integer.MAX_VALUE);

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < node; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < line; i++) {
            int start = read()-1;
            int end = read()-1;
            int cost = read();
            graph.get(start).add(new Node(end,cost));
        }

        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));
        pq.add(new Node(begin,0));
        costs[begin] = 0;

        while(!pq.isEmpty()) {
            Node n = pq.poll();
            int i = n.getIndex();
            int d = n.getDistance();
            if(costs[i] < d) continue;

            List<Node> nowGraph = graph.get(i);
            for (int j = 0; j < nowGraph.size(); j++) {
                int cost = costs[i] + nowGraph.get(j).getDistance();
                if(cost < costs[nowGraph.get(j).getIndex()]) {
                    costs[nowGraph.get(j).getIndex()] = cost;
                    pq.add(new Node(nowGraph.get(j).getIndex(),cost));
                }
            }
        }

        for (int i = 0; i < node; i++) {
            if(costs[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(costs[i]);
            }
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

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
}
