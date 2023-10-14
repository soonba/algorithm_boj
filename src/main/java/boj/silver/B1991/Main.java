package boj.silver.B1991;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static final int end = -19;
    static int[][] graph;
    static StringBuilder total = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        //0좌 1우
        graph = new int[26][2];
        for (int i = 0; i < 26; i++) {
            graph[i][0] = end;
            graph[i][1] = end;
        }
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            char[] charArray = s.toCharArray();
            graph[charArray[0] - 65][0] = charArray[2] - 65;
            graph[charArray[0] - 65][1] = charArray[4] - 65;
        }

//        전위순회(Preorder Traversal)
        preorder(0);
        total.append("\n");
//        중위순회(Inorder Traversal)
        inorder(0);
        total.append("\n");
//        후위순회(Postorder Traversal)
        postorder(0);
        System.out.println(total);
    }

    private static void postorder(int nodeIndex) {
        if(nodeIndex == end) return;
        postorder(graph[nodeIndex][0]);
        postorder(graph[nodeIndex][1]);
        total.append((char)(nodeIndex + 65));
    }

    private static void inorder(int nodeIndex) {
        if(nodeIndex == end) return;
        inorder(graph[nodeIndex][0]);
        total.append((char)(nodeIndex + 65));
        inorder(graph[nodeIndex][1]);
    }

    private static void preorder(int nodeIndex) {
        if(nodeIndex == end) return;
        total.append((char)(nodeIndex + 65));
        preorder(graph[nodeIndex][0]);
        preorder(graph[nodeIndex][1]);
    }
}
