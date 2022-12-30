package unclassified.page;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

//최대 1000000000
public class Main {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        int i1 = scanner.nextInt();
//        String bigDecimalStr = bigDecimal.toString();
//        int length = bigDecimalStr.length();
//        String substring = bigDecimalStr.substring(length - 1, length);
        for (int n =1; n <= 10000; n = n+1000) {
            final int nn = n;
            int[] numbers = {0,0,0,0,0,0,0,0,0,0};
            for (int i = 1; i <= n; i++) {
                String s = Integer.toString(i);
                String[] split = s.split("");
                for (int j = 0; j < split.length; j++) {
                    int i2 = Integer.parseInt(split[j]);
                    numbers[i2]++;
                }
            }
            String format = String.format("%-" + 4 + "s", nn);
            System.out.print(format+": ");
            Arrays.stream(numbers).forEach(a -> System.out.print(String.format("%-" + 3 + "s", a)+" "));
            System.out.println();
        }




    }
}
