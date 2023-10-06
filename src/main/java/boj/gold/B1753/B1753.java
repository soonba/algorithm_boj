package boj.gold.B1753;

import java.util.*;

//다익스트라 우선순위 큐
public class B1753 {
    public static void main(String[] args) throws Exception {
        //vertex
        int v = read();
        //edge
        int e = read();
        int beginIndex = read() - 1;

        //최소비용배열 - 노드의 개수만큼
        int[] costs = new int[v];
        //모든 비용 무한대로 설정
        Arrays.fill(costs, Integer.MAX_VALUE);

        //edge 정보 담은 그래프
        List<List<Node>> graph = new ArrayList<>();
        // 그래프 리스트 초기화
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int start = read()-1;
            int end = read()-1;
            int cost = read();
            //start 그래프에 목적지 index가 end이고 비용이 cost인 Node 추가
            graph.get(start).add(new Node(end,cost));
        }

        //queue 를 생성하고 queue에 시작지점, 비용 0의 노드 추가
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));
        pq.add(new Node(beginIndex,0));
        //시작지점의 비용은 0
        costs[beginIndex] = 0;

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            //현재 노드의 인덱스
            int now = poll.getIndex();

            //시작지점에서 현재 노드까지의 단순 주어진 비용(최신화 고려 안됨)
            int distance = poll.getDistance();

            //현재 노드의 인덱스 최소 비용이 단순비용보다 이미 작다면 통과
            if(costs[now] < distance) continue;

            //아니라면 해당 노드가 가진 간선들에 대해 순회
            //해당 노드가 가진 노드들
            List<Node> nodes = graph.get(now);
            for (int i = 0; i < nodes.size(); i++) {
                //기존 최소비용에 해당 노드의 비용을 더한 값이 새로운 비용
                int newCost = costs[now] + nodes.get(i).getDistance();
                //만약 새로운 값이 해당 노드의 인덱스까지의 최소비용보다 작다면 갱신하고, 시작지점에서 해당 노드까지의 비용 노드 추가
                int targetIndex = nodes.get(i).getIndex();
                if(newCost < costs[targetIndex]) {
                    costs[targetIndex] = newCost;
                    pq.add(new Node(targetIndex,newCost));
                }
            }
        }

        for (int cost : costs) {
            String out = cost == Integer.MAX_VALUE ? "INF" : String.valueOf(cost);
            System.out.println(out);
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
