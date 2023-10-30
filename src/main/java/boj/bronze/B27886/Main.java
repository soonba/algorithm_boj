package boj.bronze.B27886;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Sprout
//3
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        int read = Integer.parseInt(br.readLine());
        String[] split = t.split("");
        System.out.println(split[read-1]);
    }
}
