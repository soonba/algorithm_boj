package data_structure.double_pqueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            DoublePriorityQueue doublePriorityQueue = new DoublePriorityQueue();
            int process = Integer.parseInt(br.readLine());
            for (int j = 0; j < process; j++) {
                String[] s = br.readLine().split(" ");
                String method = s[0];
                int value = Integer.parseInt(s[1]);

                if(method.equals("I")) {
                    doublePriorityQueue.I(value);
                } else {
                    doublePriorityQueue.D(value);
                }
            }
            sb.append(doublePriorityQueue.print()).append("\n");
        }

        System.out.println(sb);
    }
}

class DoublePriorityQueue {
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    void I (int i) {
        Integer orDefault = treeMap.getOrDefault(i,0);
        treeMap.put(i,orDefault+1);
    }

    void D (int i) {
        if(treeMap.isEmpty()) return;
        Map.Entry<Integer, Integer> entry;
        entry = i == 1 ? treeMap.lastEntry() : treeMap.firstEntry();
        Integer key = entry.getKey();
        Integer value = entry.getValue();
        if(value == 1) {
            treeMap.remove(key);
        } else {
            treeMap.put(key, value-1);
        }
    }

    String print() {
        if(treeMap.isEmpty()) return "EMPTY";
        return treeMap.lastKey() + " " + treeMap.firstKey();
    }
}
