package math.findPrimeNumber;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int min = Integer.parseInt(s[0]);
        int max = Integer.parseInt(s[1]);

        StringBuilder sb = new StringBuilder();
        boolean[] num = new boolean[max+1];
        num[0] = true;
        num[1] = true;
        for (int i = 0; i <= max; i++) {
            if(num[i]) {
                continue;
            }
            if(i >= min) {
                sb.append(i).append("\n");
            }
            int multiple = 0;
            // 좀 더 깔끔하게..?
            while(true) {
                multiple += i;
                if(multiple > max) {
                    break;
                }
                num[multiple] = true;
            }
        }
        System.out.println(sb);
    }

}
