package boj.silver.B9375;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            Map<String, Integer> map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            for (int j = 0; j < N; j++) {
                String s = br.readLine();
                String[] split = s.split(" ");
                String t = split[1];
                Integer orDefault = map.getOrDefault(t, 0);
                map.put(t, orDefault + 1);
            }
            Set<String> strings = map.keySet();
            int result = 1;
            for (String string : strings) {
                Integer in = map.get(string);
                result *= in+1;
            }
            sb.append(result-1).append("\n");
        }
        System.out.println(sb);
    }
}
