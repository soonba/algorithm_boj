package graph.componant_count;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        int NODE_COUNT = read();
        int LINE_COUNT = read();
        LinkedList<Integer>[] nodeList = new LinkedList[NODE_COUNT + 1];
        visited = new boolean[NODE_COUNT + 1];

        for (int i = 0; i <= NODE_COUNT; i++) {
            nodeList[i] = new LinkedList<>();
        }

        for (int i = 0; i < LINE_COUNT; i++) {
            int a = read();
            int b = read();
            nodeList[a].add(b);
            nodeList[b].add(a);
        }

        int count = 0;
        for (int i = 1; i < visited.length; i++) {
            if (visited[i]) continue;

            count++;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = true;
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();

                for (int j = 0; j < nodeList[poll].size(); j++) {
                    Integer num = nodeList[poll].get(j);
                    if(visited[num]) continue;
                    queue.add(num);
                    visited[num] = true;
                }
            }
        }

        System.out.println(count);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
