package unclassified.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int index = 0;
        for (int i = 0; i < 9; i++) {
            int i1 = Integer.parseInt(br.readLine());
            if(i1 >= max) {
                max = i1;
                index = i+1;
            }
        }

        System.out.println(max+"\n"+index);

    }
}
