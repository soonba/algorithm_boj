package sorting.ATM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        int T = read();

        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            numList.add(read());
        }
        Collections.sort(numList);
        int result = 0;
        int temp = 0;
        for (int i = 0; i < T; i++) {
            temp += numList.get(i);
            result += temp;
        }

        System.out.println(result);
    }


    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
