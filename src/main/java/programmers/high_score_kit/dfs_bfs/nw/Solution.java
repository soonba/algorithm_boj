package programmers.high_score_kit.dfs_bfs.nw;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static boolean[] visits;
    static List<Integer>[] nodeList;
    public int solution(int n, int[][] computers) {
        nodeList = new List[n];
        for (int i = 0; i < n; i++) {
            nodeList[i] = new ArrayList<>();
            int[] computer = computers[i];
            for (int j = 0; j < computer.length; j++) {
                if(i==j) continue;
                if(computer[j] == 1) nodeList[i].add(j);
            }
        }

        visits = new boolean[n];
        int network = 0;

        for (int i = 0; i < n; i++) {
            if(visits[i]) continue;
            network++;
            dfs(i);
        }
        return network;
    }

    private void dfs(int i) {
        if(visits[i]) return;
        visits[i] = true;
        nodeList[i].forEach(this::dfs);
    }
}

