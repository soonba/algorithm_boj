package data_structure.make_bigger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int length = Integer.parseInt(s[0]);
        int erase = Integer.parseInt(s[1]);
        int resultLength = length - erase;
        char[] chars = br.readLine().toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        deque.push(chars[0]);
        int cur = 0;
        for (int i = 1; i < length; i++) {
            while((!deque.isEmpty()) && (erase > 0) && (chars[i] > deque.peek())) {
                deque.poll();
                erase--;
            }
            if(deque.size() < resultLength) {
                deque.push(chars[i]);
            }
            cur = i+1;
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
        }
        for (int i = cur; i < length; i++) {
            sb.append(chars[i]);
        }
        System.out.println(sb);
    }
}
