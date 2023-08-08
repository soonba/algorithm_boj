package data_structure.absolute_heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static final int POP = 0;
    static final Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == POP) {
                if(pq.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    int[] poll = pq.poll();
                    sb.append(poll[0] * poll[1]).append("\n");
                }
            } else {
                if(num < 0) {
                    pq.add(new int[] {num * -1,-1});
                } else {
                    pq.add(new int[] {num, 1});
                }
            }
        }

        System.out.println(sb);

    }
}
