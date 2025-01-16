package normalization.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    //node 번호와 연결된 리스트로 그래프를 구성할 수 있음
    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static boolean[] visited;
    private static int depthCnt = 5;

    public static void main(String[] args) throws Exception {
//        임의로 데이터 추가
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(5));
        graph.put(3, Arrays.asList(5));
        graph.put(5, Arrays.asList(7));
        graph.put(7, Collections.emptyList());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        visited = new boolean[T + 1];
        //1. 방문이 전역으로 처리
        //지금 노드만 체크하면 되기 떄문에 파라미터는 1개
        dfsGlobal(0);

        //2. 모든 dfs를 수행해야함 = 모든 노드를 시작점으로 탐색해야함
        for (int i = 0; i < T; i++) {
            dfsGlobal(i);
        }

        //3. dfs에서 depth가 정해져 해당 깊이에 도달하면 어떤 로직을 체크해서 총 만족하는 카운트를 찾는 경우
        dfsDepth(0, 0);

        //4. 방문 경로를 각자 관리 (파라미터)
        dfsLocal(0, new boolean[T]);
    }

    private static void dfsLocal(int node, boolean[] localVisited) {
        localVisited[node] = true; // 현재 경로에서 방문 체크
        System.out.println("경로 방문: " + node);

        for (int next : graph.get(node)) {
            if (!localVisited[next]) {
                dfsLocal(next, localVisited.clone()); // 복제한 방문 정보로 다음 노드 탐색
            }
        }
    }

    private static void dfsDepth(int node, int depth) {
        visited[node] = true;
        if(depth == depthCnt) {
            System.out.print(depth + " ");
        }
        List<Integer> neighbors = graph.get(node);
        for (Integer neighbor : neighbors) {
            if (!visited[neighbor]) {
                dfsDepth(neighbor, depth + 1);
            }
        }
    }

    static void dfsGlobal(int node) {
        visited[node] = true; // 방문 체크
        System.out.println("방문: " + node);

        for (int next : graph.get(node)) {
            //애초에 호출 안하는 방향으로 가도 좋을듯
            if (!visited[next]) {
                dfsGlobal(next); // 다음 노드로 이동
            }
        }
    }
}
