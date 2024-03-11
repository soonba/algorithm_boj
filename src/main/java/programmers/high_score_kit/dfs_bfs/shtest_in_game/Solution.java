package programmers.high_score_kit.dfs_bfs.shtest_in_game;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    final int[] dx = {1, -1, 0, 0};
    final int[] dy = {0, 0, 1, -1};

    public int solution(int[][] maps) {
        Queue<Node> q = new LinkedList<>();
        int n = maps.length;
        int m = maps[0].length;

        q.add(new Node(0, 0, 1));
        maps[0][0] = 0;
        while (!q.isEmpty()) {
            Node now = q.poll();
            int nX = now.x;
            int nY = now.y;
            for (int i = 0; i < 4; i++) {
                int nextX = nX + dx[i];
                int nextY = nY + dy[i];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || maps[nextX][nextY] == 0) continue;
                maps[nextX][nextY] = 0;
                if (nextX == n - 1 && nextY == m - 1) return now.score + 1;
                q.add(new Node(nextX, nextY, now.score + 1));
            }
        }
        return -1;
    }
}

class Node {
    int x;
    int y;
    int score;

    public Node(int x, int y, int score) {
        this.x = x;
        this.y = y;
        this.score = score;
    }
}
