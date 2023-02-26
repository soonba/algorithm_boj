package math.common_factor_multiple;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//2609
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int MCF = a>b ? maximumCommonFactor(a,b) : maximumCommonFactor(b,a);
        int MCM = a>b ? minimumCommonMultiple(a,b) : minimumCommonMultiple(b,a);
        System.out.println(MCF);
        System.out.println(MCM);

    }

    private static int maximumCommonFactor(int large, int small) {
        int mod = large % small;
        if(mod == 0) {
            return small;
        } else {
            return maximumCommonFactor(small, mod);
        }
    }

    private static int minimumCommonMultiple(int large, int small) {
        int tempLarge = large;
        int multipleValue = 1;
        while(true) {
            multipleValue++;
            if(tempLarge % small == 0) {
                return tempLarge;
            } else {
                tempLarge = large * multipleValue;
            }
        }
    }
}
