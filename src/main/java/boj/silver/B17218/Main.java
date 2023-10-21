package boj.silver.B17218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String[] split1 = s1.split(" ");
        int N = Integer.parseInt(split1[0]);
        int T = Integer.parseInt(split1[1]);

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] split = s.split(" ");
            map.put(split[0],split[1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            sb.append(map.get(s)).append("\n");
        }
        System.out.println(sb);
    }
}
