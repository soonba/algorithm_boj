package boj.gold.B1504;


//다익스트라 여러번
//s -> p1
//p1-> p2 (p1->e 도 알 수 있음)
//p2 -> e
//4 6
//1 2 3
//2 3 3
//3 4 1
//1 3 5
//2 4 5
//1 4 4
//2 3
public class Main {
    static int n;
    static final int MAXIMUM_DISTANCE = 800 * 1001;
    static final int MAXIMUM_INDEX = 801;
    static int[][] initGraph;
    public static void main(String[] args) throws Exception {
        n = read();
        int e = read();

        initGraph = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==j) {
                    initGraph[i][j] = 0;
                } else {
                    initGraph[i][j] = MAXIMUM_DISTANCE;
                }
            }
        }

        for (int i = 0; i < e; i++) {
            int start = read()-1;
            int end = read()-1;
            int distance = read();
            initGraph[start][end] = distance;
            initGraph[end][start] = distance;
        }

        int p1 = read()-1;
        int p2 = read()-1;


        int[][] s = dijkstra(0);
        int sp1 = s[0][p1];
        int sp2 = s[0][p2];
        int[][] p1ToP2 = dijkstra(p1);
        int p1p2 = p1ToP2[p1][p2];
        int p1e = p1ToP2[p1][n-1];
        int[][] end = dijkstra(p2);
        int p2e = end[p2][n-1];
        int result = Math.min(sp1+p1p2+p2e, sp2 + p1p2+p1e);
        if(result == MAXIMUM_DISTANCE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }

    private static int[][] dijkstra(int start) {
        int[][] graph = initGraph;
        boolean[] visits = new boolean[n];

        visits[start] = true;
        //모든 노드에 대하여 다익스트라 수행
        for (int i = 0; i < n-1; i++) {
            int minIndex = findMinIndex(start, graph, visits);
            //한번도 업데이트 안되어 나왔다면 스킵
            if(minIndex == MAXIMUM_INDEX) continue;
            int[] targetNode = graph[minIndex];
            for (int j = 0; j < targetNode.length; j++) {
                //자기 자신은 스킵
                if(targetNode[j] == 0) continue;
                //(targetNode의 연결된 노드의 비용 + start에서 target 노드의 비용) 과 start에서 연결된 노드의 원래 비용을 비교해서 업데이트
                graph[start][j] = Math.min(graph[start][minIndex] + targetNode[j], graph[start][j]);
            }
            visits[i] = true;
        }

        return initGraph;
    }

    private static int findMinIndex(int start, int[][] graph, boolean[] visits) {
        int[] aNodeGraph = graph[start];
        int min = MAXIMUM_DISTANCE;
        int minIndex = MAXIMUM_INDEX;
        for (int i = 0; i < aNodeGraph.length; i++) {
            //방문했다면 스킵
            if(visits[i]) continue;
            int now = aNodeGraph[i];
            //최대값이면 스킵
            if(now == MAXIMUM_DISTANCE) continue;
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
