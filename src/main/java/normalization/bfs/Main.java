package normalization.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 그래프를 인접 리스트로 표현
    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static boolean[] visited;
    private static int depthCnt = 3; // 최대 깊이 제한

    public static void main(String[] args) throws Exception {
        // 임의 그래프 초기화
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(5));
        graph.put(3, Arrays.asList(5));
        graph.put(5, Arrays.asList(7));
        graph.put(7, Collections.emptyList());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        visited = new boolean[T + 1];

        // 1. 방문 전역 관리
        bfsGlobal(1);

        // 2. 모든 노드에서 BFS 호출
        for (int i = 0; i < T; i++) {
            bfsGlobal(i);
        }

        // 3. 깊이 제한 BFS
        bfsDepth(1);

        // 4. 방문 로컬 관리
        bfsLocal(1, T);
    }

    // 1. 방문 전역 관리
    private static void bfsGlobal(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println("방문: " + node);

            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }

    // 3. 깊이 제한 BFS
    private static void bfsDepth(int start) {
        Queue<int[]> queue = new LinkedList<>(); // {노드, 깊이}
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int depth = current[1];

            if (depth == depthCnt) {
                System.out.println("깊이 도달: " + node);
                continue;
            }

            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, depth + 1});
                }
            }
        }
    }

    // 4. 방문 로컬 관리
    // ? 이건 아닌듯
    private static void bfsLocal(int start, int size) {
        boolean[] localVisited = new boolean[size + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        localVisited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println("로컬 방문: " + node);

            for (int next : graph.get(node)) {
                if (!localVisited[next]) {
                    localVisited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
