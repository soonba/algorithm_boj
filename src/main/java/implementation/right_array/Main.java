package implementation.right_array;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int T = read();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            list.add(read());
        }
        Collections.sort(list);

        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            int count = 1;
            Integer integer = list.get(i);
            for (int j = i+1; j < list.size(); j++) {
                if(j == i+5) break;
                if(list.get(j) < integer +5) count++;
            }
            result = Math.max(result,count);
            if(count==5) break;
        }
        System.out.println(5-result);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
