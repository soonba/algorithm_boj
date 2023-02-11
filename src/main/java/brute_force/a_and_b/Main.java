package brute_force.a_and_b;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//23.2.11 unsolved!
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        while(T.length() >= S.length() +1) {
            String firstStr = T.substring(0, 1);
            String lastStr = T.substring(T.length()-1);
            if(lastStr.equals("A")) {
                T = T.substring(0,T.length()-1);
            }

            if(S.length() == T.length()) {
                int result = S.equals(T) ? 1 : 0;
                System.out.println(result);
                break;
            }

            if(firstStr.equals("B")) {
                T = T.substring(1);
                StringBuilder newT = new StringBuilder();
                for (int i = T.length() -1 ; i >= 0; i--) {
                    newT.append(T.charAt(i));
                }
                T = newT.toString();
            }
        }

        int result = S.equals(T) ? 1 : 0;
        System.out.println(result);
    }
}
