package implementation.pokemon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().split(" ");
        int N = Integer.parseInt(S[0]);
        int M = Integer.parseInt(S[1]);

        String[] names = new String[N];
        SortedMap<String, Integer> sortedMap = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String pokemon = br.readLine();
            names[i] = pokemon;
            sortedMap.put(pokemon, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            int integer = parseNumber(s);
            if (integer >= 0) {
                sb.append(names[integer - 1]).append("\n");
            } else {
                sb.append(sortedMap.get(s) + 1).append("\n");
            }
        }

        System.out.println(sb);

    }

    private static int parseNumber(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
