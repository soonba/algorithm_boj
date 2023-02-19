package graph.tomato;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int C = Integer.parseInt(s[0]);
        int R = Integer.parseInt(s[1]);
        int[][] nodeArr = new int[R + 1][C + 1];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        //처음 1인 노드들
        List<int[]> startNode = new ArrayList<>();
        List<String> zeroList = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                String target = s1[j];
                if (target.equals("1")) startNode.add(new int[]{i+1, j+1});
                if (target.equals("0")) zeroList.add(String.valueOf(i+1)+ (j + 1));
                nodeArr[i+1][j+1] = Integer.parseInt(target);
            }
        }

        Queue<int[]> queue = new LinkedList<>(startNode);
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            Queue<int[]> tempQueue = new LinkedList<>();
            while(!queue.isEmpty()) {
                int[] poll = queue.poll();
                int thisR = poll[0];
                int thisC = poll[1];

                for (int j = 0; j < 4; j++) {
                    int nextR = thisR + dx[j];
                    int nextC = thisC + dy[j];

                    if(nextR < 1 || nextC < 1 || nextR > R || nextC > C) continue;
                    if(nodeArr[nextR][nextC] != 0) continue;
                    tempQueue.add(new int[]{nextR,nextC});
                    nodeArr[nextR][nextC] = 1;
                    zeroList.remove(String.valueOf(nextR)+nextC);
                }
            }
            queue.addAll(tempQueue);
        }
        if(!zeroList.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(count-1);
        }


    }
}
