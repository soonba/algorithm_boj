package unclassified.Josephus0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] NK = input.split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        int baseX = 0; int baseY = 0;

        int[][] graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                String now = str[j];
                if(now.equals("B")) {
                    graph[i][j] = -2;
                    baseX = j; baseY = i;
                } else if (now.equals(".")) {
                    graph[i][j] = -1;
                } else {
                    graph[i][j] = 99999;
                }
            }
        }

        List<Integer> values = new ArrayList<>();

        for(int y = 0; y < N; y++) {
            for(int x =0; x < N; x++) {
                if(graph[y][x] == 99999) {
                    int val = Math.abs(baseX - x) + Math.abs(baseY - y);
                    values.add(val);
                    graph[y][x] = val;
                }
            }
        }

        Collections.sort(values);
        if(values.size() < K) {
            System.out.println(-1);
            return;
        }

        int crit = values.get(K-1);
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int y = 0; y < N; y++) {
            for(int x =0; x < N; x++) {
                int now = graph[y][x];
                if(now == -1) {
                    sb.append(".");
                } else if(now > 0){
                    if(now <= crit && count < K) {
                        count++;
                        sb.append("X");
                    } else {
                        sb.append("O");
                    }
                } else {
                    sb.append("B");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
