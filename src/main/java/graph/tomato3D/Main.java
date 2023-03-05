package graph.tomato3D;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int C = Integer.parseInt(s[0]);
        int R = Integer.parseInt(s[1]);
        int H = Integer.parseInt(s[2]);
        int[][][] nodeArr = new int[R + 1][C + 1][H + 1];
        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        List<int[]> startNode = new ArrayList<>();
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < R; i++) {
                String[] s1 = br.readLine().split(" ");
                for (int j = 0; j < C; j++) {
                    String target = s1[j];
                    if (target.equals("1")) startNode.add(new int[]{i + 1, j + 1, k + 1});
                    nodeArr[i + 1][j + 1][k + 1] = Integer.parseInt(target);
                }
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
                int thisH = poll[2];

                for (int j = 0; j < 6; j++) {
                    int nextR = thisR + dx[j];
                    int nextC = thisC + dy[j];
                    int nextH = thisH + dz[j];

                    if(nextR < 1 || nextC < 1 || nextH < 1 || nextR > R || nextC > C || nextH > H) continue;
                    if(nodeArr[nextR][nextC][nextH] != 0) continue;
                    tempQueue.add(new int[]{nextR,nextC,nextH});
                    nodeArr[nextR][nextC][nextH] = 1;
                }
            }
            queue.addAll(tempQueue);
        }
        boolean anyZero = false;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                for (int k = 1; k <= H; k++) {
                    if (nodeArr[i][j][k] == 0) {
                        anyZero = true;
                        break;
                    }
                }
            }
        }
        if(anyZero) {
            System.out.println(-1);
        } else {
            System.out.println(count-1);
        }
    }
}
