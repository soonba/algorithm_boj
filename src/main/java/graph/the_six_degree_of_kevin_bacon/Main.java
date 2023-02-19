package graph.the_six_degree_of_kevin_bacon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int USER = Integer.parseInt(s[0]);
        int NODE = Integer.parseInt(s[1]);

        LinkedList<Integer>[] nodeList = new LinkedList[USER + 1];
        for (int i = 0; i < NODE; i++) {
            String[] friend = br.readLine().split(" ");
            int f1 = Integer.parseInt(friend[0]);
            int f2 = Integer.parseInt(friend[1]);
            if (nodeList[f1] == null) nodeList[f1] = new LinkedList<>();
            if (nodeList[f2] == null) nodeList[f2] = new LinkedList<>();
            nodeList[f1].add(f2);
            nodeList[f2].add(f1);
        }

        for (int i = 1; i < nodeList.length; i++) {
            Collections.sort(nodeList[i]);
        }

        int min_kevin_bacon_number = Integer.MAX_VALUE;
        int min_kevin_bacon_user = 0;
        for (int i = 1; i <= USER; i++) {
            int kevin_bacon_number = 0;
            for (int j = 1; j <= USER; j++) {
                int[] nodeValue = new int[USER + 1];
                if (i == j) continue;
                Queue<Integer> queue = new LinkedList<>();
                boolean[] visit = new boolean[USER + 1];
                visit[i] = true;
                queue.add(i);
                nodeValue[i] = 0;
                int aNodeValue = 0;
                while (!queue.isEmpty()) {
                    Integer thisNode = queue.poll();
                    for (int k = 0; k < nodeList[thisNode].size(); k++) {
                        Integer nextNode = nodeList[thisNode].get(k);
                        if (visit[nextNode]) continue;
                        nodeValue[nextNode] = nodeValue[thisNode] + 1;
                        if (nextNode == j) {
                            aNodeValue = nodeValue[nextNode];
                            queue.clear();
                            break;
                        }
                        visit[nextNode] = true;
                        queue.add(nextNode);
                    }
                }
                kevin_bacon_number += aNodeValue;
            }
            if (min_kevin_bacon_number > kevin_bacon_number) {
                min_kevin_bacon_user = i;
            }
            min_kevin_bacon_number = Math.min(min_kevin_bacon_number, kevin_bacon_number);
        }

        System.out.println(min_kevin_bacon_user);
    }
}
