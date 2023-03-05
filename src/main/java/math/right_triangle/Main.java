package math.right_triangle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String[] s = br.readLine().split(" ");
            if(s[0].equals("0")) {
                break;
            }
            int[] ints = Stream.of(s).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(ints);
            if ((ints[2] * ints[2]) == (ints[1] * ints[1]) + (ints[0] * ints[0])) {
                sb.append("right").append("\n");
            } else {
                sb.append("wrong").append("\n");
            }
        }
        System.out.println(sb);
    }
}
