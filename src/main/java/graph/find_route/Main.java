package graph.find_route;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int NODE = Integer.parseInt(br.readLine());
        LinkedList<Integer>[] nodeList = new LinkedList[NODE+1];
        for (int i = 0; i < NODE; i++) {
            String[] s = br.readLine().split(" ");
            nodeList[i+1] = new LinkedList<>();
            for (int j = 0; j < NODE; j++) {
                if(s[j].equals("1")) {
                    nodeList[i+1].add(j+1);
                }
            }
        }

        for (LinkedList<Integer> lists : nodeList) {
            if(lists != null){
                Collections.sort(lists);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= NODE; i++) {
            for (int j = 1; j <= NODE; j++) {
                boolean[] visited = new boolean[NODE+1];
                String canGo = "0";
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                while(!queue.isEmpty() && canGo != "1") {
                    Integer poll = queue.poll();
                    if(nodeList[poll] == null) {
                        break;
                    }
                    for (int k = 0; k < nodeList[poll].size(); k++) {
                        Integer nextNode = nodeList[poll].get(k);
                        if(nextNode.equals(j)) {
                            canGo = "1";
                            break;
                        }
                        if(visited[nextNode]) {
                            continue;
                        }
                        visited[nextNode] = true;
                        queue.add(nextNode);
                    }
                }

                sb.append(canGo).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
