package data_structure.card2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < T; i++) {
            queue.add(i + 1);
        }

        while (queue.size() > 1) {
            queue.poll();
            Integer poll = queue.poll();
            queue.add(poll);
        }
        System.out.println(queue.poll());
    }

}

