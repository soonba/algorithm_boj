package dfs.dfs_bfs;

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1260
 * Level: SILVER II
 * Algorithm: DFS, BFS
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*

 */
public class Main {
    static LinkedList<Integer>[] nodeList;
    static boolean[] visitBFS;
    static boolean[] visitDFS;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int node = Integer.parseInt(s[0]);
        int lineInfo = Integer.parseInt(s[1]);
        int startNode = Integer.parseInt(s[2]);

        //노드 초기화
        nodeList = new LinkedList[node + 1];
        for (int i = 0; i < nodeList.length; i++) {
            nodeList[i] = new LinkedList<>();
        }
        for (int i = 0; i < lineInfo; i++) {
            String[] s1 = br.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            //방향이 상관 없으므로 a, b 두 노드 모두 등록
            nodeList[a].add(b);
            nodeList[b].add(a);
        }

        // 작은 수부터 탐색하기 위해 정렬
        for (LinkedList<Integer> integers : nodeList) {
            Collections.sort(integers);
        }


        //dfs
        StringBuilder dfsResult = new StringBuilder();
        visitDFS = new boolean[node + 1];
        dfs(startNode,dfsResult);


        //bfs
        visitBFS = new boolean[node + 1];
        Queue<Integer> bfsQueue = new LinkedList<>();

        //첫 노드를 queue에 넣고 while문 시작
        visitBFS[startNode] = true;
        bfsQueue.add(startNode);

        StringBuilder bfsResult = new StringBuilder();
        while (!bfsQueue.isEmpty()) {

            Integer poll = bfsQueue.poll();
            bfsResult.append(poll).append(" ");

            //poll() 을 해주면서 해당 node의 모든 노드를 담는다. 이 때 이미 방문했다면 패스
            for (int i = 0; i < nodeList[poll].size(); i++) {
                Integer nextNode = nodeList[poll].get(i);
                if (!visitBFS[nextNode]) {
                    bfsQueue.add(nextNode);
                    visitBFS[nextNode] = true;
                }
            }
        }

        System.out.println(dfsResult);
        System.out.println(bfsResult);

    }

    static void dfs(int node, StringBuilder result) {
        //이미 방문한 노드라면 패스
        if(visitDFS[node]) {
            return;
        }

        //방문
        StringBuilder addedResult = result.append(node).append(" ");
        visitDFS[node] = true;
        for (int i = 0; i < nodeList[node].size(); i++) {
            //다음 노드 방문을 위한 재귀 호출
            Integer nextNode = nodeList[node].get(i);
            dfs(nextNode,addedResult);
        }
    }

}
