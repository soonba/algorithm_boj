package brute_force.a_and_b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        boolean convertable = false;
        Queue<String> queue = new LinkedList<>();
        queue.add(T);
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            if(poll.length() < S.length()) {
                continue;
            }
            if(poll.equals(S)) {
                convertable = true;
                break;
            }
            char first = poll.charAt(0);
            char last = poll.charAt(poll.length()-1);

            if (first == 'A' && last == 'A') {
                queue.add(poll.substring(0,poll.length()-1));
            } else if (first == 'B' && last == 'B' ) {
                String minusFirst = poll.substring(1);
                StringBuilder sb = new StringBuilder(minusFirst);
                queue.add(sb.reverse().toString());
            } else if (first == 'B' && last == 'A') {
                queue.add(poll.substring(0,poll.length()-1));
                String minusFirst = poll.substring(1);
                StringBuilder sb = new StringBuilder(minusFirst);
                queue.add(sb.reverse().toString());
            }

        }

        if(convertable) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
