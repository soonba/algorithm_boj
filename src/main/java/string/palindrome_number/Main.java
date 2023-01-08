package string.palindrome_number;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        while(!(s = br.readLine()).equals("0")) {
            int length = s.length();
            int loop = length / 2;
            String check = "yes";
            for (int i = 0; i < loop; i++) {
                String front = s.substring(i, i + 1);
                String end = s.substring(length-1-i, length-i);
                if (!front.equals(end)) {
                    check = "no";
                    break;
                }
            }
            sb.append(check);
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
