package boj.silver.B10816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        Map<String,Integer> map = new HashMap<>();
        String s = br.readLine();
        String[] split = s.split(" ");
        for (String item : split) {
            Integer orDefault = map.getOrDefault(item, 0);
            map.put(item, orDefault + 1);
        }
        br.readLine();
        String s1 = br.readLine();
        String[] split1 = s1.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String value : split1) {
            sb.append(map.getOrDefault(value, 0)).append(" ");
        }

        System.out.println(sb.substring(0,sb.length()-1));
    }
}
