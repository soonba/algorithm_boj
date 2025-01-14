package kep.t4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean[] visits;
    static int count = 0;
    static int K;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] arr = input.split(" ");
        N = Integer.parseInt(arr[0]);//뭉치 <=1000
        K = Integer.parseInt(arr[1]);//뽑기 <=47
        visits = new boolean[N];
        for (int i = 0; i < N; i++) {
            dfs(i, new ArrayList<>());
        }
        System.out.println(count);
    }

    private static void dfs(int i, List<Integer> numList) {
        if(visits[i]) return;
        numList.add(i);
        if(numList.size() == K) {
            Integer reduce = numList.stream().reduce(0, Integer::sum);
            if(reduce % N == 0) {
                numList.forEach(el -> visits[el] = true);
                count++;
            }
            return;
        }
        for (int j = i+1; j < N; j++) {
            dfs(j, new ArrayList<>(numList));
        }
    }
}
