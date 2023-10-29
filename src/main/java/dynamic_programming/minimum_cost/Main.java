package dynamic_programming.minimum_cost;

import java.util.LinkedList;

public class Main {
    static int[][] nodes;
    static int N; //집 개수
    static int M; //간선의 개수
    static boolean[] visits; //방문 여부
    static int[] distance;

    static final int MAX_COST = 100_000;

    public static void main(String[] args) throws Exception {
        N = read();
        M = read();
        nodes = new int[N][N];
        int totalMaxCost = (N - 1) * MAX_COST;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    nodes[i][j] = 0;
                    continue;
                }
                nodes[i][j] = totalMaxCost;
            }
        }

        for (int i = 0; i < M; i++) {
            int start = read()-1;
            int end = read()-1;
            int cost = read();
            nodes[start][end] = cost;
        }
        
        int[][] resultSet = new int[N][N];

        for (int i = 0; i < N; i++) {
            visits = new boolean[N];
            distance = new int[N];
            dijkstra(i);
            resultSet[i] = distance;
        }
        int A = read() - 1;
        int B = read() - 1;
        System.out.println(resultSet[A][B]);
    }

    private static void dijkstra(int start) {
        for (int i = 0; i < N; i++) {
            distance[i] = nodes[start][i];
        }
        visits[start] = true;

        for (int i = 0; i < N-2; i++) { 
            int current = getMinCostIndex();
            visits[current] = true;

            for (int j = 0; j < N; j++) {
                if(!visits[j]) {
                    distance[j] = Math.min(distance[j],distance[current]+ nodes[current][j] );
                }
            }
        }
    }

    private static int getMinCostIndex() {
        int min = (N-1) * MAX_COST + 1;
        int index = 0;
        for (int i = 0; i < distance.length; i++) {
            if(!visits[i] && distance[i] < min) {
                min = distance[i];
                index = i;
            }
        }
        return index;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
