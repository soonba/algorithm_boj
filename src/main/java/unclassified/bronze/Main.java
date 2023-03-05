package unclassified.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String result = s.equals("1 2 3 4 5 6 7 8") ? "ascending" : s.equals("8 7 6 5 4 3 2 1") ? "descending" : "mixed";
        System.out.println(result);
    }
}