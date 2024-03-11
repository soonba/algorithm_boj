package boj.gold.B1865;

public class Main {

    public static final int MAX_VALUE = 500 * 10000 + 1;

    public static void main(String[] args) throws Exception {
        int TC = read();//1~5
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < TC; i++) {
            sb.append(process()).append("\n");
        }
        System.out.println(sb);
    }

    private static String process() throws Exception {
        int n = read(); //1~500 노드
        int e = read(); //1~2500 선
        int w = read(); //1~200 웜홀

        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = i == j ? 0 : MAX_VALUE;
            }
        }

        for (int i = 0; i < e; i++) {
            int st = read();
            int ed = read();
            int dt = read();
            if (graph[st][ed] > dt) {
                graph[st][ed] = dt;
                graph[ed][st] = dt;
            }
        }
        for (int i = 0; i < w; i++) {
            int st = read();
            int ed = read();
            int dt = read();
            int idt = dt * -1;
            if (graph[st][ed] > idt) {
                graph[st][ed] = idt;
            }
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                int[] nodes = graph[j];
                for (int k = 1; k < nodes.length; k++) {
                    int dt = nodes[k];
                    //해당 노드가 연결된 인덱스, 거리
                    graph[i][k] = Math.min(graph[1][k], graph[1][j] + dt);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if(graph[i][i] < 0) return "YES";
        }
        return "NO";
    }

    private static int read() throws Exception {
        boolean isMinus = false;

        int c, n = System.in.read();
        if (n == 45) {
            isMinus = true;
            n = System.in.read();
        }
        n &= 15;

        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);

        if (isMinus)
            return ~n + 1;
        else
            return n;
    }
}