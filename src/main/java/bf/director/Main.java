package bf.director;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int i = Integer.parseInt(s);

        int num = 666;
        int count = 1;

        while (i != count) {
            num++;
            if (String.valueOf(num).contains("666")) {
                count++;
            }
        }

        System.out.println(num);
    }
}
