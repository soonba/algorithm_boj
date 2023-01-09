package bf.decomposition;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer s = Integer.parseInt(br.readLine());
        Integer result = 0;
        for (Integer i = (s- (9*s.toString().length())); i < s; i++) {
            Integer sum = i;
            Integer count = i;
            while(count != 0) {
                sum += count % 10;
                count /= 10;
            }

            if(sum.equals(s)) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
