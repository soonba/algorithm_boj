package string.word_sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<String> words = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String next = br.readLine();
            words.add(next);
        }

        words.stream().sorted(new Comp()).forEach(System.out::println);

    }

}

class Comp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() != o2.length()) {
            return o1.length() - o2.length();
        } else {
            for (int i = 0; i < o1.length(); i++) {
                int a = o1.charAt(i);
                int b = o2.charAt(i);
                if (a != b) {
                    return a - b;
                }
            }
            return 0;
        }
    }
}
