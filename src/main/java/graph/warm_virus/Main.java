package graph.warm_virus;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        int computerCount = read();
        LinkedList<Integer>[] nodeList = new LinkedList[computerCount + 1];
        for (int i = 0; i < nodeList.length; i++) {
            nodeList[i] = new LinkedList<>();
        }
        int linkCount = read();
        for (int i = 0; i < linkCount; i++) {
            int a = read();
            int b = read();
            nodeList[a].add(b);
            nodeList[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        boolean[] answerArr = new boolean[computerCount + 1];

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (answerArr[poll]) continue;

            answerArr[poll] = true;
            LinkedList<Integer> next = nodeList[poll];
            queue.addAll(next);
        }

        int count = 0;
        for (boolean b : answerArr) {
            if (b) count++;
        }
        System.out.println(count-1);

    }


    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
