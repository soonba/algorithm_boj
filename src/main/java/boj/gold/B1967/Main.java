package boj.gold.B1967;


public class Main {
    static int[][] initGraph;
    static int N;
    static final int MAX_DISTANCE = 1000 * 100;
    public static void main(String[] args) throws Exception {
        N = read();
        initGraph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i==j) continue;
                initGraph[i][j] = MAX_DISTANCE;
            }
        }
        for (int i = 0; i < N - 1; i++) {
            int start = read()-1;
            int end = read()-1;
            int distance = read();
            initGraph[start][end] = distance;
            initGraph[end][start] = distance;
        }

        int[][] zeroToMax = dijkstra(0);
        int maxIndex = 0;
        int max = 0;
        int[] zeroToMax1 = zeroToMax[0];
        for (int i = 0; i < N; i++) {
            int now = zeroToMax1[i];
            if(now == MAX_DISTANCE) continue;
            max = Math.max(now,max);
            if(max == now) {
                maxIndex = i;
            }
        }

        int[][] dijkstra = dijkstra(maxIndex);
        int max2 = 0;
        int[] zeroToMax2 = dijkstra[maxIndex];
        for (int i = 0; i < N; i++) {
            int now2 = zeroToMax2[i];
            if(now2 == MAX_DISTANCE) continue;
            max2 = Math.max(now2,max2);
        }
        System.out.println(max2);

    }

    private static int[][] dijkstra(int startIndex) {
        int[][] graph = initGraph;
        boolean[] visits = new boolean[N];
        visits[startIndex] = true;
        for (int i = 0; i < N; i++) {
            int minIndex = findMinIndex(startIndex, graph, visits);
            if(minIndex == N) continue;
            int[] targetGraph = graph[minIndex];
            for (int j = 0; j < targetGraph.length; j++) {
                if(targetGraph[j] ==0) continue;
                graph[startIndex][j] = Math.min(graph[startIndex][minIndex]+targetGraph[j], graph[startIndex][j] );
            }
            visits[minIndex] = true;
        }

        return graph;

    }

    private static int findMinIndex(int start, int[][] graph, boolean[] visits) {
        int[] aNodeGraph = graph[start];
        int min = MAX_DISTANCE;
        int minIndex = N;
        for (int i = 0; i < aNodeGraph.length; i++) {
            //방문했다면 스킵
            if(visits[i]) continue;
            int now = aNodeGraph[i];
            //최대값이면 스킵
            if(now == MAX_DISTANCE) continue;
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